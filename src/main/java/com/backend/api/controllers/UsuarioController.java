package com.backend.api.controllers;


import com.backend.api.models.jpa.Usuario;
import com.backend.api.service.IService;
import com.backend.api.utils.JWTUtil;
import com.backend.api.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    //Anotacion para crear automaticamente un objeto Usuarioservice
    //y aplicarle un patron singleton
    @Qualifier("UsuarioServiceImp")
    @Autowired
    private IService<Usuario> service;

    @GetMapping(value = "/{id}")
    public Usuario getUser(@PathVariable Long id) {
        System.out.println("RECOMPILE");
        return RestPreconditions.checkFound(service.get(id));
    }

    // @PreAuthorize("hasRole('ADMIN')")
    // Dejar solo el @Request header da acceso independiente del rol, basta
    // con que el token sea valido
    // @PreAuthorize chequea el token y el rol
    @GetMapping
    public List<Usuario> getUsers(@RequestHeader("Authorization") String token) {
        return service.get();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
    public void deleteUser(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        service.delete(id);
    }

    /**
     * Method to create a new user
     *
     * @param usuario
     * @return ResponseBody
     */
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Usuario usuario) {
        service.create(usuario);
        return ResponseEntity.ok(usuario);
    }

}
