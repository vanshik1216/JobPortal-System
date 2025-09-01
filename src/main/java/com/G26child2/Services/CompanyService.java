package com.G26child2.Services;

import com.G26child2.Dao.CompanyDao;
import com.G26child2.Entity.Company;

import java.util.List;

public class CompanyService {
    private CompanyDao companyDao;

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    // Register Company
    public void registerCompany(Company company) {
        companyDao.saveCompany(company);
    }

    // Company Login
    public Company loginCompany(String email, String password) {
        List<Company> companies = companyDao.getCompanies();
        for (Company c : companies) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                return c;  // Login success
            }
        }
        return null; // Login failed
    }
}
