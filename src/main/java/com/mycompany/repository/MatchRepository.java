package com.mycompany.repository;

import com.mycompany.model.CricketMatch;
import com.mycompany.model.Player;
import com.mycompany.repository.generic.GenericRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MatchRepository extends GenericRepository<CricketMatch, Long> {

    
     @PersistenceContext(name = "cricketscorerwebapp")
    private static EntityManager entityManager;


    public MatchRepository() {
        super(CricketMatch.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
