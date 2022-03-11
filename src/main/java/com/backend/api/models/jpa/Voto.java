package com.backend.api.models.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "voto")
@NamedQueries({
        @NamedQuery(name = "Voto.countByIdCandidato_NombreCandidato", query = "select count(v) from Voto v where v.idCandidato.nombreCandidato = :nombreCandidato"),
        @NamedQuery(name = "Voto.findAll", query = "select v from Voto v")
})
public class Voto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "idVoto", nullable = false)
    private Integer id;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCandidato")
    @JsonBackReference
    private Candidato idCandidato;

    @Getter @Setter @Column(name = "voto", nullable = false)
    private Integer voto;

    public int getIdCandidatoId(){
        return this.idCandidato.getId();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voto))
            return false;
        Voto other = (Voto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }
}