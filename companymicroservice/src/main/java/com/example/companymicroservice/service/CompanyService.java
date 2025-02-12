package com.example.companymicroservice.service;

import com.example.companymicroservice.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    boolean updateCompany(Long id, Company updatedCompany);
}
