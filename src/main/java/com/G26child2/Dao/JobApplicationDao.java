package com.G26child2.Dao;

import com.G26child2.Entity.JobApplication;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class JobApplicationDao {
    private HibernateTemplate ht;

    public HibernateTemplate getHt() {
        return ht;
    }

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }

    @Transactional
    public void saveApplication(JobApplication application) {
        ht.save(application);
    }

    public JobApplication getApplicationById(int id) {
        return ht.get(JobApplication.class, id);
    }

    public List<JobApplication> getAllApplications() {
        return ht.loadAll(JobApplication.class);
    }
    @Transactional
    public void updateApplication(JobApplication application) {
        ht.update(application);
    }
    @Transactional
    public void deleteApplication(int id) {
        JobApplication app = ht.get(JobApplication.class, id);
        if (app != null) {
            ht.delete(app);
        }
    }
}
