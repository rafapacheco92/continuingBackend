package com.example.testeProva.dtos.res;

import java.util.List;

public class ShowTarefaDTO {

  private Long id;
  private String titulo;
  private ShowResponsavelDTO responsavel;
  private List<ShowUsuarioDTO> usuarios;

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

  public ShowResponsavelDTO getResponsavel() {
    return responsavel;
  }

  public void setResponsavel(ShowResponsavelDTO responsavel) {
    this.responsavel = responsavel;
  }

  public List<ShowUsuarioDTO> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<ShowUsuarioDTO> usuarios) {
    this.usuarios = usuarios;
  }

}
