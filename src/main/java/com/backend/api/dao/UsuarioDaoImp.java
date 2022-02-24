package com.backend.api.dao;

import com.backend.api.models.jpa.Usuario;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public Usuario userByEmail(String usermail) {
        List<Usuario> user = entityManager.createNamedQuery("Usuario.checkEmail", Usuario.class)
                .setParameter("emailParam", usermail)
                .getResultList();
        if(user.isEmpty())
            return null;
        return user.get(0);
    }


}
