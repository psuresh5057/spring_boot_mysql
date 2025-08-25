package com.spring.boot.azure.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "job_title")
public class JobTitle {

    @Id
    @Column(name = "job_title_id")
    private Integer jobTitleId;
    @Column(name = "job_title_name")
    private String jobTitleName;
}
