package com.backend.api.service;

import com.backend.api.dao.IDao;
import com.backend.api.models.jpa.Candidato;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CandidatoServiceImp")
public class CandidatoServiceImp implements IService<Candidato> {
    @Autowired
    private IDao<Candidato> dao;

    @Override
    public List<Candidato> get() {
        return dao.get();
    }

    @Override
    public Candidato get(Long T) {
        return dao.get(T);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void create(Candidato candidato) {
        dao.create(candidato);
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
    public Candidato objByUniqueParam(String uniqueParam) {
       return dao.objByUniqueParam(uniqueParam);
    }
}
