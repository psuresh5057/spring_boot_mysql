package com.spring.boot.mysql.service.impl;

import com.spring.boot.mysql.model.Department;
import com.spring.boot.mysql.model.JobTitle;
import com.spring.boot.mysql.repository.JobTitleRepository;
import com.spring.boot.mysql.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleServiceImpl implements JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    @Override
    public String saveJobTitle(List<JobTitle> jobTitle) {
        String status = "Job Title saved successfully";
        try {
            jobTitleRepository.saveAll(jobTitle);
        } catch (Exception e) {
            status = "Error saving Job title: " + e.getMessage();
        }
        return status;
    }

    @Override
    public JobTitle getJobById(Integer jobId) {
        return jobTitleRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job Title not found with id: " + jobId));
    }

    @Override
    public List<JobTitle> getAllJobTitles() {
        return jobTitleRepository.findAll();
    }

    @Override
    public JobTitle getJobTitleByName(String jobTitleName) {
        return jobTitleRepository.getJobTitleByName(jobTitleName)
                .orElseThrow(() -> new RuntimeException("Job Title not found with name: " + jobTitleName));
    }
}
