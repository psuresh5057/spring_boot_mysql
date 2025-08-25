package com.spring.boot.azure.mysql.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="gender")
    private String gender;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "hire_date")
    private String hiredate;
    @Column(name = "salary")
    private double salary;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    @ManyToOne
    @JoinColumn(name = "job_title_id", nullable = true)
    private JobTitle jobTitle;

}

