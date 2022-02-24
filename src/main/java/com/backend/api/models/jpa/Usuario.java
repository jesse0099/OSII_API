package com.backend.api.models.jpa;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "usuarios")
@NamedQueries({
        @NamedQuery(name=  "Usuario.getAll", query = "SELECT u FROM Usuario u")
        ,@NamedQuery(name= "Usuario.checkEmail", query="SELECT u FROM Usuario u WHERE u.email = :emailParam")
        ,@NamedQuery(name= "Usuario.getById", query="SELECT u FROM Usuario u WHERE u.id = :idParam")
})
@ToString @EqualsAndHashCode
public class Usuario implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "password")
    private String password;

    @Getter @Setter @Column(name = "role")
    private String roles;

    @Getter @Setter @Column(name = "active")
    private Boolean active;

}
