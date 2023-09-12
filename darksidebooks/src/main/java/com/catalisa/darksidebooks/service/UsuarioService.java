package com.catalisa.darksidebooks.service;

import com.catalisa.darksidebooks.model.UsuarioModel;
import com.catalisa.darksidebooks.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioModel cadastraUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public Optional<UsuarioModel> buscaPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public List<UsuarioModel> listaTodos(){
        return usuarioRepository.findAll();
    }

    public void deletaUsuario(Long id){
       usuarioRepository.deleteById(id);
    }

}
