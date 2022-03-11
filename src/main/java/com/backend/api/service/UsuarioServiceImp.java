package com.backend.api.service;


import com.backend.api.dao.IDao;
import com.backend.api.dao.UsuarioDaoImp;
import com.backend.api.models.generics.MyUserDetails;
import com.backend.api.models.jpa.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UsuarioServiceImp")
public class UsuarioServiceImp implements IService<Usuario>, UserDetailsService {
    @Autowired
    private IDao<Usuario> dao;

    public UsuarioServiceImp() {
    }

    @Override
    public List<Usuario> get() {
        return dao.get();
    }

    @Override
    public Usuario get(Long T) {
        return dao.get(T);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void create(Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        //Param 1 = iteraciones del hash , Param 2 = Memoria, Param 3 = Hilos de ejecucion, Param 4 = password para hashear
        String passHashed = argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(passHashed);
        dao.create(usuario);
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
        return 0;
    }

    @Override
    public Usuario objByUniqueParam(String uniqueParam) {
        return dao.objByUniqueParam(uniqueParam);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario fetchedUser = new Usuario();

        fetchedUser = ((UsuarioDaoImp)dao).userByEmail(s);

        if(fetchedUser == null)
            throw new  UsernameNotFoundException("El usuario "+s+" no fue encontrado!");
        return new MyUserDetails(fetchedUser);
    }

}
