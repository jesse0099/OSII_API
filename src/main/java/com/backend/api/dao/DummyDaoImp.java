package com.backend.api.dao;

import com.backend.api.models.jpa.Dummy;
import org.hibernate.cfg.NotYetImplementedException;
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
    public void deleteByParam(String uniqueParam) {

    }

    @Override
    public boolean exists(String uniqueParam) {
        return false;
    }

    @Override
    public int countByParam(String param) {
        return -1;
    }

    @Override
    public Dummy objByUniqueParam(String uniqueParam) {
        throw  new NotYetImplementedException("Implementación Pendiente");
    }

    @Override
    public Dummy get(Long id) {
        return Optional.ofNullable(entityManager.createNamedQuery("Dummy.getById", Dummy.class)
                .setParameter("idParam",id)
                .getSingleResult()).get();
    }
}
