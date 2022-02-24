package com.backend.api.controllers;

import com.backend.api.models.generics.AuthenticationRequest;
import com.backend.api.models.generics.AuthenticationResponse;
import com.backend.api.models.jpa.Usuario;
import com.backend.api.service.IService;
import com.backend.api.service.UsuarioServiceImp;
import com.backend.api.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.PermitAll;


@RestController @RequestMapping("api/auth")
public class AuthController {

    @Qualifier("UsuarioServiceImp")
    @Autowired
    private IService<Usuario> service;

    @Autowired
    @Qualifier("JWT")
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    //@Secured({"ROLE_USER"})

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user/hello")
    public String hello(){
        return "HellO!";
    }

    //@Secured({"ROLE_ADMIN","ROLE_SADMIN"})
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_SADMIN')")
    @GetMapping("/admin/helloAdmin")
    public String helloAdmin(){
        return "HellO Admin!";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') AND hasRole('ROLE_SADMIN')")
    @GetMapping("/admin/helloSuperAdmin")
    public String helloSuperAdmin(@RequestParam(value = "OptionalParam", required = false) String opt){
        return "HellO  Super Admin!";
    }


    @PermitAll
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest)throws BadCredentialsException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));

        }catch (BadCredentialsException be){
            //Autenticacion fallida
            //throw  new BadCredentialsException("Credenciales Incorrectas",be);
            return ResponseEntity.ok(new AuthenticationResponse("FAIL"));
        }

        //Una vez lograda la autenticacion se procede a crear el token

        UserDetails loggedUser = ((UsuarioServiceImp)service).loadUserByUsername(authenticationRequest.getUsername());

        String token = jwtUtil.generateToken(loggedUser);

        return  ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
