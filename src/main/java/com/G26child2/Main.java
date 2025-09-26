package com.G26child2;

import com.G26child2.Dao.JobApplicationDao;
import com.G26child2.Entity.Candidate;
import com.G26child2.Entity.Company;
import com.G26child2.Entity.Job;
import com.G26child2.Entity.JobApplication;
import com.G26child2.Services.CandidateService;
import com.G26child2.Services.CompanyService;
import com.G26child2.Services.JobApplicationService;
import com.G26child2.Services.JobService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import  java.util.*;
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");

        CompanyService companyService = (CompanyService) ac.getBean("companyService");
        CandidateService candidateService = (CandidateService) ac.getBean("candidateService");
        JobService jobService = (JobService) ac.getBean("jobService");
        JobApplicationService jobAppService = (JobApplicationService) ac.getBean("jobApplicationService");

        Scanner sc = new Scanner(System.in);
        int choice;
        while(true) {
            System.out.println("\n=== Job Portal ===");
            System.out.println("1. Company");
            System.out.println("2. Candidate");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Company
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.print("Choice: ");
                    int c = sc.nextInt();
                    sc.nextLine();
                    if (c == 1) {
                        Company comp = new Company();
                        System.out.print("Name: ");
                        comp.setName(sc.nextLine());
                        System.out.print("Email: ");
                        comp.setEmail(sc.nextLine());
                        System.out.print("Password: ");
                        comp.setPassword(sc.nextLine());
                        companyService.registerCompany(comp);
                        System.out.println("Company Registered!");
                    } else if (c == 2) {
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Password: ");
                        String pass = sc.nextLine();
                        Company comp = companyService.loginCompany(email, pass);
                        if (comp != null) {
                            System.out.println("Login Success!");
                            System.out.println("1. Post Job  2. View Jobs  3.Delete Job 4.View Job Applications");
                            int d = sc.nextInt();
                            sc.nextLine();
                            if (d == 1) {
                                Job job = new Job();
                                job.setCompany(comp);

                                System.out.print("Title: ");
                                job.setTitle(sc.nextLine());
                                System.out.print("Description: ");
                                job.setDescription(sc.nextLine());
                                System.out.print("Package Offered: ");
                                job.setPackageOffered(sc.nextInt());
                                jobService.postJob(job);
                                System.out.println("Job Posted!");
                            } else if (d == 2) {
                                List<Job> jobs = jobService.getAllJobs();
                                if (jobs.isEmpty()) {
                                    System.out.println("No jobs available.");
                                } else {
                                    System.out.println("Available Jobs:");
                                    for (Job j : jobs) {
                                        System.out.println("ID:" + j.getId());
                                        System.out.println("Title:" + j.getTitle());
                                    }
                                }
                            } else if (d == 3) {
                                int id = sc.nextInt();
                                jobService.deleteJob(id);
                                System.out.println("Job Deleted Successfully!");
                            } else if (d == 4) {
                                List<JobApplication> application = JobApplicationService.getAllApplications();
                                if (application.isEmpty()) {
                                    System.out.println("No jobs available.");
                                } else {
                                    System.out.println("Available Applications:");
                                    for (JobApplication ja : application) {
                                        System.out.println("ID:" + ja.getId());
                                        System.out.println("Candidate ID:" + ja.getCandidate().getName());
                                        System.out.println("Job ID:" + ja.getJob().getTitle());
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid Credentials!");
                        }
                    }
                    break;

                case 2: // Candidate
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.print("Choice: ");
                    int e = sc.nextInt();
                    sc.nextLine();
                    if (e == 1) {
                        Candidate cand = new Candidate();
                        System.out.print("Name: ");
                        cand.setName(sc.nextLine());
                        System.out.print("Email: ");
                        cand.setEmail(sc.nextLine());
                        System.out.print("College: ");
                        cand.setCollege(sc.nextLine());
                        System.out.print("Experience: ");
                        cand.setExperience(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Password: ");
                        cand.setPassword(sc.nextLine());
                        candidateService.registerCandidate(cand);
                        System.out.println("Candidate Registered!");
                    } else if (e == 2) {
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Password: ");
                        String pass = sc.nextLine();
                        Candidate cand = candidateService.loginCandidate(email, pass);
                        if (cand != null) {
                            System.out.println("Login Success!");
                            System.out.println("1. View Jobs  2. Apply for Job");
                            int f = sc.nextInt();
                            sc.nextLine();
                            if (f == 1) {
                                List<Job> jobs = jobService.getAllJobs();
                                if (jobs.isEmpty()) {
                                    System.out.println("No jobs available.");
                                } else {
                                    System.out.println("Available Jobs:");
                                    for (Job j : jobs) {
                                        System.out.println("ID:" + j.getId());
                                        System.out.println("Title:" + j.getTitle());
                                        System.out.println("Package Offered:" + j.getPackageOffered());
                                    }
                                }
                            } else if (f == 2) {
                                List<Job> jobs = jobService.getAllJobs();
                                if (jobs.isEmpty()) {
                                    System.out.println("No jobs available.");
                                } else {
                                    System.out.println("Available Jobs:");
                                    for (Job j : jobs) {
                                        System.out.println("ID:" + j.getId());
                                        System.out.println("Title:" + j.getTitle());
                                    }

                                    System.out.print("Enter JobId to apply: ");
                                    int jid = sc.nextInt();
                                    sc.nextLine();
                                    Job job = jobService.getJobById(jid);

                                    if (job != null) {
                                        JobApplication app = new JobApplication(cand, job);
                                        app.setCandidate(cand);
                                        app.setJob(job);
                                        jobAppService.applyForJob(app);

                                        System.out.println("Application Submitted!");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid Credentials!");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;
            }
        }
    }
}