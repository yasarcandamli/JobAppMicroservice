package com.example.jobmicroservice.service;

import com.example.jobmicroservice.dto.JobDTO;
import com.example.jobmicroservice.entity.Job;
import com.example.jobmicroservice.external.Company;
import com.example.jobmicroservice.repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        for (Job job : jobs) {
            JobDTO jobDTO = new JobDTO();
            jobDTO.setJob(job);

            Company company = restTemplate.getForObject("http://localhost:8081/companies/" + job.getCompanyId(),
                    Company.class);
            jobDTO.setCompany(company);
            jobDTOS.add(jobDTO);
        }
        return jobDTOS;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
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
