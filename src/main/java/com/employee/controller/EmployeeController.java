package com.employee.controller;

import com.employee.Entity.Employee;
import com.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/hello")
    public String test(){
        return "Hello World!!";
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee(){
        List<Employee> employees= employeeService.getEmployee();
        System.out.println("Hello World!");
        employees.stream().forEach(e-> System.out.println(e.getEmpName()));
        return employees;
    }

}
