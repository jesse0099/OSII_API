package com.backend.api.dao;

import com.backend.api.models.jpa.Candidato;
import com.backend.api.models.jpa.Voto;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class VotoDaoImp implements  IDao<Voto> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Voto> get() {
        return entityManager.createNamedQuery("Voto.findAll", Voto.class).getResultList();
    }

    @Override
    public Voto get(Long id) {
        return entityManager.find(Voto.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Voto.class, id));
    }

    @Override
    public void create(Voto voto) {
        entityManager.persist(voto);
    }

    @Override
    public void deleteByParam(String uniqueParam) {
        throw  new NotYetImplementedException("Implementación Pendiente");
    }

    @Override
    public boolean exists(String uniqueParam) {
        throw  new NotYetImplementedException("Implementación Pendiente");
    }

    @Override
    public int countByParam(String param) {
        return Integer.parseInt(entityManager.createNamedQuery("Voto.countByIdCandidato_NombreCandidato" ,Long.class)
                .setParameter("nombreCandidato" ,param)
                .getSingleResult().toString());
    }

    @Override
    public Voto objByUniqueParam(String uniqueParam) {
        return null;
    }
}
