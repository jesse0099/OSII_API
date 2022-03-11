package com.backend.api.models.jpa;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "candidato")
@NamedQueries({
        @NamedQuery(name = "Candidato.findAll", query = "select c from Candidato c"),
        @NamedQuery(name = "Candidato.existsByNombreCandidato", query = "select (count(c) > 0) from Candidato c where c.nombreCandidato = :nombreCandidato"),
        @NamedQuery(name = "Candidato.deleteByNombreCandidato", query = "delete from Candidato c where c.nombreCandidato = :nombreCandidato"),
        @NamedQuery(name = "Candidato.updateNombreCandidatoById", query = "update Candidato c set c.nombreCandidato = :nombreCandidato where c.id = :id"),
        @NamedQuery(name = "Candidato.objectByName", query = "select c from Candidato c where c.nombreCandidato = :nombreCandidato")
})
public class Candidato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "idCandidato", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "nombreCandidato", nullable = false, length = 100)
    private String nombreCandidato;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCandidato")
    @JsonManagedReference
    private Set<Voto> votos = new LinkedHashSet<>();

    public void addVoto(Voto voto){
        this.votos.add(voto);
        voto.setIdCandidato(this);
    }
}