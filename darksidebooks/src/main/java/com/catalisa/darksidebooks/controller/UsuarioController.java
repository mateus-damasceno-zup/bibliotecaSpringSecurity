package com.catalisa.darksidebooks.controller;

import com.catalisa.darksidebooks.model.LivroModel;
import com.catalisa.darksidebooks.model.UsuarioModel;
import com.catalisa.darksidebooks.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/usuarios")
    public List<UsuarioModel> buscaTodosUsuarios(){
        return usuarioService.listaTodos();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/usuarios/{id}")
    public Optional<UsuarioModel> buscarLivroPorId(@PathVariable Long id){
        return usuarioService.buscaPorId(id);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(path = "/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel cadastrarNovoUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.cadastraUsuario(usuarioModel);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/usuarios/{id}")
    public void deletaUsuario(@PathVariable Long id){
        usuarioService.deletaUsuario(id);
    }
}
