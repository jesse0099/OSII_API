package com.backend.api.dao;

import com.backend.api.models.jpa.Usuario;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements IDao<Usuario> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> get() {
        return entityManager.createNamedQuery("Usuario.getAll",Usuario.class).getResultList();
    }

    @Override
    public Usuario get(Long id) {
        return entityManager.createNamedQuery("Usuario.getById", Usuario.class)
                .setParameter("idParam", id)
                .getSingleResult();
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Usuario.class,id));
    }

    @Override
    public void create(Usuario usuario) {
        entityManager.persist(usuario);
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
    public Usuario objByUniqueParam(String uniqueParam) {
        throw  new NotYetImplementedException("Implementación Pendiente");
    }

    public Usuario userByEmail(String usermail) {
        List<Usuario> user = entityManager.createNamedQuery("Usuario.checkEmail", Usuario.class)
                .setParameter("emailParam", usermail)
                .getResultList();
        if(user.isEmpty())
            return null;
        return user.get(0);
    }


}
