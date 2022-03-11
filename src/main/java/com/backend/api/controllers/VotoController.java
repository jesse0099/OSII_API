package com.backend.api.controllers;

import com.backend.api.models.generics.VotoRequest;
import com.backend.api.models.jpa.Candidato;
import com.backend.api.models.jpa.Voto;
import com.backend.api.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("api/votos")
public class VotoController {
    @Autowired
    private IService<Voto> service;

    @Autowired IService<Candidato> candidatoService;

    //Get All
    @PermitAll
    @GetMapping
    public List<Voto> getVoto(){
        return service.get();
    }

    //Get Count
    @PermitAll
    @GetMapping("/{candidato}")
    public int getCount(@PathVariable String candidato){
        return service.countByParam(candidato);
    }

    //Create
    @PermitAll
    @PostMapping
    public ResponseEntity<?> createVoto(@RequestBody VotoRequest voto){
        try {

            Candidato tmp = candidatoService.objByUniqueParam(voto.getCandidato());

            Voto persisted = new Voto();
            persisted.setVoto(1);
            tmp.addVoto(persisted);
            service.create(persisted);

            tmp.getVotos().add(persisted);
            return ResponseEntity.ok(voto);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
