package com.backend.api.service;

import com.backend.api.dao.IDao;
import com.backend.api.models.jpa.Dummy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DummyServiceImp")
public class DummyServiceImp implements IService<Dummy> {
    @Autowired
    private IDao<Dummy> dao;

    @Override
    public List<Dummy> get() {
        return dao.get();
    }

    @Override
    public Dummy get(Long T) {
        return dao.get(T);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void create(Dummy dummy) {
        dao.create(dummy);
    }
}
