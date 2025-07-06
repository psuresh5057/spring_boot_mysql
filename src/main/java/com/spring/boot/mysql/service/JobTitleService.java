package com.spring.boot.mysql.service;

import com.spring.boot.mysql.model.JobTitle;

import java.util.List;

public interface JobTitleService {
   String saveJobTitle(List<JobTitle> jobTitleList);
   JobTitle getJobById(Integer jobId);
   List<JobTitle> getAllJobTitles();
   JobTitle getJobTitleByName(String jobTitleName);
}

