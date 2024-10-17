package com.example.testeProva.models;

public class Maria extends Usuario {
    
    @Override
    public double calculaSalario(Integer horas, double valorHora) {
        if (horas > 0) {
            return valorHora + ((horas - 1) * valorHora);
        }

        return this.valorHora;
    }
}
