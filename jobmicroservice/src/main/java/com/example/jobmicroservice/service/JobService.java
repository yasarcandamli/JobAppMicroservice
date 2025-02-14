package com.example.jobmicroservice.service;

import com.example.jobmicroservice.dto.JobDTO;
import com.example.jobmicroservice.entity.Job;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
