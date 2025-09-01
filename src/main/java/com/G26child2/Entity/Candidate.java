package com.G26child2.Entity;
import java.util.*;
import javax.persistence.*;

@Entity
public class Candidate {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String college;
    private int experience; // in years
    private String password;
    public Candidate() {
    }
    public Candidate(String name, String email, String college, int experience, String password) {

        this.name = name;
        this.email = email;
        this.college = college;
        this.experience = experience;
        this.password = password;
    }

    public int getId() {
        return id;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", college='" + college + '\'' +
                ", experience=" + experience +
                ", password='" + password + '\'' +
                '}';
    }
}
