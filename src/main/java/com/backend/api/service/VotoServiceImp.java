package com.backend.api.service;

import com.backend.api.dao.IDao;
import com.backend.api.models.jpa.Voto;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("VotoServiceImp")
public class VotoServiceImp implements IService<Voto>{
    @Autowired
    private IDao<Voto> dao;

    @Override
    public List<Voto> get() {
        return dao.get();
    }

    @Override
    public Voto get(Long T) {
        return dao.get(T);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void create(Voto voto) {
        dao.create(voto);
    }

    @Override
    public void deleteByParam(String uniqueParam) {
        dao.deleteByParam(uniqueParam);
    }

    @Override
    public boolean exists(String uniqueParam) {
        return dao.exists(uniqueParam);
    }

    @Override
    public int countByParam(String param) {
        return dao.countByParam(param);
    }

    @Override
    public Voto objByUniqueParam(String uniqueParam) {
        throw  new NotYetImplementedException("Implementación Pendiente");
    }
}
