package com.spring.boot.azure.mysql.repository;

import com.spring.boot.azure.mysql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.department.departmentId = :departmentId")
    List<Employee> findEmployeesByDepartmentId(Integer departmentId);
}
