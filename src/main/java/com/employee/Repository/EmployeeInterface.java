package com.employee.Repository;

import com.employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInterface extends JpaRepository<Employee,Integer> {
}
