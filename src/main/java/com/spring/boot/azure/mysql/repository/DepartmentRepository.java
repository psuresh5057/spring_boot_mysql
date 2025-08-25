package com.spring.boot.azure.mysql.repository;

import com.spring.boot.azure.mysql.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT d FROM Department d WHERE  d.departmentName= :deptName")
    Optional<Department> findByDepartmentName(String deptName);
}
