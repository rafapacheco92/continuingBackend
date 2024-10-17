package com.example.testeProva.models;

import com.example.testeProva.interfaces.IUsuarios;

public abstract class Usuario implements IUsuarios {
    protected final double valorHora = 50;

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
