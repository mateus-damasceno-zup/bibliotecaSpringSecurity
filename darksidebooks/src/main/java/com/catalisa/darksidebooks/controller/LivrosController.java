package com.catalisa.darksidebooks.controller;

import com.catalisa.darksidebooks.model.LivroModel;
import com.catalisa.darksidebooks.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/livros")
public class LivrosController {

    @Autowired
    LivrosService livrosService;
    @PreAuthorize("permitAll()")
    @GetMapping
    public List<LivroModel> buscaTodosLivros(){
        return livrosService.buscarTodos();
    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/{id}")
    public Optional<LivroModel> buscarLivroPorId(@PathVariable Long id){
        return livrosService.buscarPorId(id);
    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroModel cadastrarNovoLivro(@RequestBody LivroModel livroModel){
        return livrosService.cadastrar(livroModel);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public LivroModel alteraDados(@PathVariable Long id,
                                  @RequestBody LivroModel livroModel){
        return livrosService.alterar(id, livroModel);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/delete/{id}")
    public void deletaLivro(@PathVariable Long id){
        livrosService.deletar(id);
    }

}