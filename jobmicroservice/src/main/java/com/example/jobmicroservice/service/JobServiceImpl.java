package com.example.jobmicroservice.service;

import com.example.jobmicroservice.dto.JobDTO;
import com.example.jobmicroservice.entity.Job;
import com.example.jobmicroservice.external.Company;
import com.example.jobmicroservice.external.Review;
import com.example.jobmicroservice.mapper.JobMapper;
import com.example.jobmicroservice.repository.JobRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    private final RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository, RestTemplate restTemplate) {
        this.jobRepository = jobRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();

        return jobs.stream().map(this::convertToDTO).toList();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDTO(job);
    }

    private JobDTO convertToDTO(Job job) {
        Company company = restTemplate.getForObject("http://COMPANYMICROSERVICE:8081/companies/" + job.getCompanyId(),
                Company.class);
        ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange(
                "http://REVIEWMICROSERVICE:8083/reviews?companyId=" + job.getCompanyId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>() {
                }
        );
        List<Review> reviews = reviewResponse.getBody();
        JobDTO jobDTO = JobMapper.mapToJobDTO(job, company, reviews);
        return jobDTO;
    }

    @Override
    public boolean deleteJobById(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        } else {
            return false;
        }
    }
}
