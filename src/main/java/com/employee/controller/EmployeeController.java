package com.employee.controller;

import com.employee.Beans.Department;
import com.employee.Entity.Employee;
import com.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String test() {
        return "Hello World!!";
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        List<Employee> employees = employeeService.getEmployee();
        System.out.println("Hello World!");
        employees.stream().forEach(e -> System.out.println(e.getEmpName()));
        return employees;
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {

        String url = "http://department-container:8080/departments";

        ResponseEntity<List<Department>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Department>>() {
                        }
                );

        List<Department> departments = response.getBody();
        departments.forEach(de -> System.out.println(de.getDepartments()));

        boolean found = departments.stream()
                .anyMatch(de -> de.getDepartments()
                        .equalsIgnoreCase(employee.getDepartmentName()));

        if (found) {
            employeeService.saveEmployee(employee);
        } else {
            System.out.println("Department not found");
        }
    }

}
