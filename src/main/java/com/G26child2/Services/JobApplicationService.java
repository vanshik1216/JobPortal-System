package com.G26child2.Services;

import com.G26child2.Dao.JobApplicationDao;
import com.G26child2.Entity.JobApplication;

import java.util.ArrayList;
import java.util.List;

public class JobApplicationService {
    private static JobApplicationDao jobApplicationDao;
    private List<JobApplication> applications = new ArrayList<>();


    public void setJobApplicationDao(JobApplicationDao jobApplicationDao) {
        this.jobApplicationDao = jobApplicationDao;
    }

    // Apply for a Job
    public void applyForJob(JobApplication app) {
        jobApplicationDao.saveApplication(app);
    }

    // View application by id
    public JobApplication getApplicationById(int id) {
        return jobApplicationDao.getApplicationById(id);
    }

    // View all applications
    public static List<JobApplication> getAllApplications() {
        return jobApplicationDao.getAllApplications();
    }

    // Update application
    public void updateApplication(JobApplication app) {
        jobApplicationDao.updateApplication(app);
    }

    // Delete application
    public void deleteApplication(int id) {
        jobApplicationDao.deleteApplication(id);
    }


}
