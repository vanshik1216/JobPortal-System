package com.G26child2.Dao;

import com.G26child2.Entity.Company;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class CompanyDao {
    private HibernateTemplate ht;

    public HibernateTemplate getHt() {
        return ht;
    }

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }

    @Transactional
    public void saveCompany(Company company) {
        ht.save(company);
    }

    public Company getCompanyById(int id) {
        return ht.get(Company.class, id);
    }

    public List<Company> getCompanies() {
        return ht.loadAll(Company.class);
    }
    @Transactional
    public void updateCompany(Company company) {
        ht.update(company);
    }
    @Transactional
    public void deleteCompany(int id) {
        Company company = ht.get(Company.class, id);
        if (company != null) {
            ht.delete(company);
        }
    }
}
