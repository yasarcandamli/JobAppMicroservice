package com.example.jobmicroservice.dto;

import com.example.jobmicroservice.entity.Job;
import com.example.jobmicroservice.external.Company;

public class JobDTO {
    private Job job;
    private Company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
