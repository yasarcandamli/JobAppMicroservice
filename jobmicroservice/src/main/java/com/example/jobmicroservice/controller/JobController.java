package com.example.jobmicroservice.controller;

import com.example.jobmicroservice.entity.Job;
import com.example.jobmicroservice.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,
                                            @RequestBody Job updatedJob) {
        boolean isUpdated = jobService.updateJob(id, updatedJob);
        if (isUpdated) {
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
    }
}
