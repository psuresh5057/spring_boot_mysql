package com.spring.boot.mysql.controller;

import com.spring.boot.mysql.model.JobTitle;
import com.spring.boot.mysql.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @PostMapping(value = "/save")
    public ResponseEntity<String> createJobTitle(@RequestBody List<JobTitle> jobTitle) {
         String  status =jobTitleService.saveJobTitle(jobTitle);
        return ResponseEntity.ok(status);
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
}
