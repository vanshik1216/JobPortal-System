package com.G26child2.Services;

import com.G26child2.Dao.CandidateDao;
import com.G26child2.Entity.Candidate;

import java.util.List;

public class CandidateService {
    private CandidateDao candidateDao;

    public void setCandidateDao(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    // Register Candidate
    public void registerCandidate(Candidate candidate) {
        candidateDao.saveCandidate(candidate);
    }

    // Candidate Login
    public Candidate loginCandidate(String email, String password) {
        List<Candidate> candidates = candidateDao.getCandidates();
        for (Candidate c : candidates) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                return c; // Login success
            }
        }
        return null; // Login failed
    }
}
