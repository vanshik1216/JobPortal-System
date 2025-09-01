package com.G26child2.Entity;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private double packageOffered;
    @ManyToOne
    Company company;
public Job(){}
    public Job(String title, String description, double packageOffered) {

        this.title = title;
        this.description = description;
        this.packageOffered = packageOffered;
    }

    public int getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPackageOffered() {
        return packageOffered;
    }

    public void setPackageOffered(double packageOffered) {
        this.packageOffered = packageOffered;
    }
}
