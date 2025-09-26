package com.G26child2.Services;

import com.G26child2.Dao.JobDao;
import com.G26child2.Entity.Job;

import java.util.List;

public class JobService {
    private  JobDao jobDao;

    public void setJobDao(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    // Post a new Job
    public void postJob(Job job) {
        jobDao.saveJob(job);
    }

    // View a job
    public  Job getJobById(int id) {
        return jobDao.getJobById(id);
    }

    // View all jobs
    public List<Job> getAllJobs() {
        return jobDao.getAllJobs();
    }

    // Update job
    public void updateJob(Job job) {
        jobDao.updateJob(job);
    }

    // Delete job
    public void deleteJob(int id) {
        jobDao.deleteJob(id);
    }

}
