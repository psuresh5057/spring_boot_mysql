package com.spring.boot.mysql.controller;

import com.spring.boot.mysql.model.JobTitle;
import com.spring.boot.mysql.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/job")
public class JobTitleController {

    private static final Logger logger = LoggerFactory.getLogger(JobTitleController.class);

    @Autowired
    private JobTitleService jobTitleService;

    /**
     * Create new Job Titles.
     * @param jobTitle List of JobTitle objects
     * @return ResponseEntity with status and message
     */
    @PostMapping(value = "/save")
    public ResponseEntity<String> createJobTitle(@RequestBody(required = false) List<JobTitle> jobTitle) {
        logger.info("Received request to create job titles: {}", jobTitle);
        if (jobTitle == null || jobTitle.isEmpty()) {
            logger.warn("JobTitle list is null or empty");
            return ResponseEntity.badRequest().body("JobTitle list cannot be null or empty");
        }
        String status = jobTitleService.saveJobTitle(jobTitle);
        if (status != null && status.toLowerCase().contains("error")) {
            logger.error("Error creating job titles: {}", status);
            return ResponseEntity.badRequest().body(status);
        }
        logger.info("Job titles created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }


    @GetMapping("/get_job_title/{jobId}")
    public ResponseEntity<JobTitle> getJobById(@PathVariable Integer jobId) {
        JobTitle jobTitle = jobTitleService.getJobById(jobId);
        return ResponseEntity.ok(jobTitle);
    }

    @GetMapping("/get_all_job_titles")
    public ResponseEntity<List<JobTitle>> getAllJobTitles() {
        List<JobTitle> jobTitleList = jobTitleService.getAllJobTitles();
        return ResponseEntity.ok(jobTitleList);
    }

    @GetMapping("/get_job_title_by_name/{jobTitleName}")
    public ResponseEntity<JobTitle> getJobTitleByName(@PathVariable String jobTitleName) {
        JobTitle jobTitle = jobTitleService.getJobTitleByName(jobTitleName);
        return ResponseEntity.ok(jobTitle);
    }

    @PostMapping("/get_job_names_by_ids")
    public ResponseEntity<List<JobTitle>> getJobNamesByIds(@RequestBody List<Integer> jobIds) {
        List<JobTitle> jobTitleList= jobTitleService.getJobNamesByIds(jobIds);
        return ResponseEntity.ok(jobTitleList);
    }

}
