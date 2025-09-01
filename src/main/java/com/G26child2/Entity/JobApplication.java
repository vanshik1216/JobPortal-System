package com.G26child2.Entity;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    Candidate candidate;
    @ManyToOne
    Job job;

    public JobApplication( Candidate candidate, Job job) {
        this.candidate = candidate;
        this.job = job;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
