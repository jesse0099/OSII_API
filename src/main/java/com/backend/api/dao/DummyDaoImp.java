package com.backend.api.dao;

import com.backend.api.models.jpa.Dummy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class DummyDaoImp implements IDao<Dummy> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Dummy> get() {
        return entityManager.createNamedQuery("Dummy.getAll",Dummy.class).getResultList();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void create(Dummy dummy) {
        entityManager.persist(dummy);
    }

    @Override
    public Dummy get(Long id) {
        return Optional.ofNullable(entityManager.createNamedQuery("Dummy.getById", Dummy.class)
                .setParameter("idParam",id)
                .getSingleResult()).get();
    }
}
