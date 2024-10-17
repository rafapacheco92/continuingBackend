package com.example.testeProva.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testeProva.Entities.UsuariosEntity;
import com.example.testeProva.Repositories.UsuariosRepository;
import com.example.testeProva.dtos.req.ChangeUsuario;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    
    @Autowired
    UsuariosRepository usuarioRepository;

    @Transactional
    public void changeUsuarioByName(String name, ChangeUsuario dto) {
        
        Optional<UsuariosEntity> optionalUsuarioEntity = usuarioRepository.findByNome(name);

        if (optionalUsuarioEntity.isEmpty()) {
            //exceção
        }

        UsuariosEntity usuariosEntity = optionalUsuarioEntity.get();

        usuariosEntity.setNome(dto.getNome());
        usuariosEntity.setEmail(dto.getEmail());

        usuarioRepository.save(usuariosEntity);
    }
}
