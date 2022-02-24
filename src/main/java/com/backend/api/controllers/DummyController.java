package com.backend.api.controllers;

import com.backend.api.models.jpa.Dummy;
import com.backend.api.service.IService;
import com.backend.api.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("api/dummies")
public class DummyController {

    //Anotacion para crear automaticamente un objeto dao
    //y aplicarle un patron singleton
    @Autowired
    private IService<Dummy> service;

    @PermitAll
    @GetMapping
    public List<Dummy> getDummies(){
        return service.get();
    }

    @PermitAll
    @GetMapping(value = "/{id}")
    public Dummy getById(@PathVariable("id") Long id){
        return RestPreconditions.checkFound(service.get(id));
    }

    @PermitAll
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Dummy dummy){
        service.create(dummy);
        return ResponseEntity.ok(dummy);
    }

}
