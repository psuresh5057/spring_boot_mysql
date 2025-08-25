package com.spring.boot.azure.mysql.repository;

import com.spring.boot.azure.mysql.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
    @Query("SELECT j FROM JobTitle j WHERE  j.jobTitleName= :jobTitleName")
    Optional<JobTitle> getJobTitleByName(String jobTitleName);

}
