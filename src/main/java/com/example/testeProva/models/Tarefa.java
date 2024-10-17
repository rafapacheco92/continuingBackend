package com.example.testeProva.models;

import java.util.List;

import com.example.testeProva.enums.Especialidade;

public class Tarefa {
    
    private Long id;
    private String titulo;
    private Especialidade especialidade;
    private Responsavel resposavel;
    private List<Usuario> usuarios;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    public Responsavel getResposavel() {
        return resposavel;
    }
    public void setResposavel(Responsavel resposavel) {
        this.resposavel = resposavel;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    
}
