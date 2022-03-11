package com.backend.api.dao;

import com.backend.api.models.jpa.Candidato;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CandidatoDaoImp implements IDao<Candidato>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Candidato> get() {
        return entityManager.createNamedQuery("Candidato.findAll",Candidato.class).getResultList();
    }

    @Override
    public Candidato get(Long id) {
        return entityManager.find(Candidato.class, id.intValue());
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Candidato.class, id));
    }

    @Override
    public void create(Candidato candidato) {
        entityManager.persist(candidato);
    }

    @Override
    public void deleteByParam(String uniqueParam) {
        entityManager.createNamedQuery("Candidato.deleteByParam", Candidato.class)
                .setParameter("nombreCandidato", uniqueParam);
    }

    @Override
    public boolean exists(String uniqueParam) {
        return entityManager.createNamedQuery("Candidato.existsByNombreCandidato", Boolean.class)
                .setParameter("nombreCandidato", uniqueParam)
                .getSingleResult();
    }

    @Override
    public int countByParam(String param) {
        throw  new NotYetImplementedException("Implementación Pendiente");
    }

    public Candidato objByUniqueParam(String uniqueParam){
        return entityManager.createNamedQuery("Candidato.objectByName", Candidato.class)
                .setParameter("nombreCandidato", uniqueParam)
                .getSingleResult();
    }

}
