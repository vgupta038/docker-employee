package com.employee.Service;

import com.employee.Entity.Employee;
import com.employee.Repository.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeInterface employeeInterface;

    public List<Employee> getEmployee(){
        return employeeInterface.findAll();
    }
}
