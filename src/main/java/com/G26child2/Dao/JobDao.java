package com.G26child2.Dao;

import com.G26child2.Entity.Job;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class JobDao {
    private HibernateTemplate ht;

    public HibernateTemplate getHt() {
        return ht;
    }

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }

    @Transactional
    public void saveJob(Job job) {
        ht.save(job);
    }

    public Job getJobById(int id) {
        return ht.get(Job.class, id);
    }

    public List<Job> getAllJobs() {
        return ht.loadAll(Job.class);
    }
    @Transactional
    public void updateJob(Job job) {
        ht.update(job);
    }
    @Transactional
    public void deleteJob(int id) {
        Job job = ht.get(Job.class, id);
        if (job != null) {
            ht.delete(job);
        }
    }
}
