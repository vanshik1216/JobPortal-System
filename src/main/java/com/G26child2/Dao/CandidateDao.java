package com.G26child2.Dao;

import com.G26child2.Entity.Candidate;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class CandidateDao {
    private HibernateTemplate ht;

    @Transactional
    public void saveCandidate(Candidate candidate) {
        ht.save(candidate);
    }

    public Candidate getCandidate(int id) {
        return ht.get(Candidate.class, id);
    }

    public List<Candidate> getCandidates() {
        return ht.loadAll(Candidate.class);
    }

    // 🔥 New method: Get candidate by email
    public Candidate getCandidateByEmail(String email) {
        return ht.execute((HibernateCallback<Candidate>) session -> {
            Query<Candidate> query = session.createQuery(
                    "from Candidate where email = :email", Candidate.class
            );
            query.setParameter("email", email);
            List<Candidate> list = query.getResultList();
            return list.isEmpty() ? null : list.get(0);
        });
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
