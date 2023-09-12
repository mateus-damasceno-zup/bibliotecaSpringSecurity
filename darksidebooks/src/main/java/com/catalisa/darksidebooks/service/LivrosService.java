package com.catalisa.darksidebooks.service;


import com.catalisa.darksidebooks.model.LivroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalisa.darksidebooks.repository.LivrosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired //Injteando o LivrosRepository na nossa classe
    LivrosRepository livrosRepository;

    public List<LivroModel> buscarTodos(){
        return livrosRepository.findAll();
    }

    public Optional<LivroModel> buscarPorId(Long id){
        return livrosRepository.findById(id);
    }

    public LivroModel cadastrar(LivroModel livroModel){

//Usar quando aprender DTO:

//        livroModel.getId();
//        livroModel.getNome();
//        livroModel.getAutor();
//        livroModel.getDataLancamento();
//        livroModel.getCodigoLivro();

        return livrosRepository.save(livroModel);
    }

    public LivroModel alterar(Long id, LivroModel livroModel){

        LivroModel livro = buscarPorId(id).get();

//Usar quando aprender DTO:

//        livroModel.getId();
//        livroModel.getNome();
//        livroModel.getAutor();
//        livroModel.getDataLancamento();
//        livroModel.getCodigoLivro();

        if (livroModel.getNome() != null){
            livro.setNome(livroModel.getNome());
        }

        if (livroModel.getAutor() != null){
            livro.setAutor(livroModel.getAutor());
        }

        if (livroModel.getDataLancamento() != null){
            livro.setDataLancamento(livroModel.getDataLancamento());
        }

        if (livroModel.getCodigoLivro() != null){
            livro.setCodigoLivro(livroModel.getCodigoLivro());
        }

        return livrosRepository.save(livro);
    }

    public void deletar(Long id){
        livrosRepository.deleteById(id);
    }
}