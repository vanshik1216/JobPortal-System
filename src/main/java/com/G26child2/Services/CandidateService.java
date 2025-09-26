package com.G26child2.Services;

import com.G26child2.Dao.CandidateDao;
import com.G26child2.Entity.Candidate;

import java.util.List;

public class CandidateService {
    private CandidateDao candidateDao;

    public void setCandidateDao(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    // Register Candidate with email check
    public String registerCandidate(Candidate candidate) {
        Candidate existing = candidateDao.getCandidateByEmail(candidate.getEmail());
        if (existing != null) {
            return "Account already exists with this email!";
        }
        candidateDao.saveCandidate(candidate);
        return "Registration successful!";
    }

    // Candidate Login
    public Candidate loginCandidate(String email, String password) {
        Candidate existingCandidate = candidateDao.getCandidateByEmail(email);
        if (existingCandidate != null && existingCandidate.getPassword().equals(password)) {
            return existingCandidate;
        }
        return null; // Login failed
    }
}
