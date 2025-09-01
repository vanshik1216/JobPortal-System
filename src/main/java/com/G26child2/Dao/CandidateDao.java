package com.G26child2.Dao;

import com.G26child2.Entity.Candidate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class CandidateDao {
   private HibernateTemplate ht;
   @Transactional
   //save candidate in db
    public void saveCandidate(Candidate candidate) {
        ht.save(candidate);
    }
    //get by id
    public Candidate getCandidate(int id) {
       return ht.get(Candidate.class, id);
    }
    //getall
    public List<Candidate> getCandidates() {
       return ht.loadAll(Candidate.class);
    }
    @Transactional
    public void updateCandidate(Candidate candidate) {
        ht.update(candidate);
    }
    @Transactional
    public void deleteCandidate(int id) {
        Candidate c = ht.get(Candidate.class, id);
        if (c != null) {
            ht.delete(c);
        }
    }
    public HibernateTemplate getHt() {
        return ht;
    }

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }
}
