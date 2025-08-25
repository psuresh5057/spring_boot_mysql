package com.spring.boot.mysql.service;

import com.spring.boot.mysql.model.Employee;

import java.util.List;

public interface EmployeeService {

    public String saveEmployee( List<Employee> employee);
    String updateEmployee(List<Employee> employee);
    List<Employee> getEmployeesListBasedOnDepartmentId(Integer departmentId);
    List<Employee> getAllEmployees();
}
