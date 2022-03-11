package com.backend.api.controllers;

import com.backend.api.models.jpa.Candidato;
import com.backend.api.service.IService;
import com.backend.api.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidatos")
public class CandidatoController {
    @Autowired
    private IService<Candidato> service;

    //Get All
    @GetMapping
    public List<Candidato> getCandidatos(){
        return service.get();
    }

    //Get By Id
    @GetMapping("/{id}")
    public Candidato getCandidato(@PathVariable Long id){
        return RestPreconditions.checkFound(service.get(id));
    }

    //Create
    @PostMapping
    public ResponseEntity<?> postCandidato(@RequestBody Candidato candidato){
        try{
            service.create(candidato);
            return ResponseEntity.ok(candidato);
        }catch (Exception ex){
            return  ResponseEntity.badRequest().body(ex);
        }
    }

}
