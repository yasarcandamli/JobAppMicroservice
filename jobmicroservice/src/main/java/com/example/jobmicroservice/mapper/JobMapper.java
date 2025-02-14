package com.example.jobmicroservice.mapper;

import com.example.jobmicroservice.dto.JobDTO;
import com.example.jobmicroservice.entity.Job;
import com.example.jobmicroservice.external.Company;
import com.example.jobmicroservice.external.Review;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobDTO(Job job, Company company, List<Review> reviews) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);

        return jobDTO;
    }
}
