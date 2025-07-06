package com.spring.boot.mysql.service;

import com.spring.boot.mysql.model.Employee;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {

    public String saveEmployee(@Valid List<Employee> employee);


    String updateEmployee(Employee employee);
}
