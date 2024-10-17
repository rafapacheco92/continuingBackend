package com.example.testeProva.services;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testeProva.Entities.ResponsaveisEntity;
import com.example.testeProva.Entities.TarefasEntity;
import com.example.testeProva.Entities.UsuariosEntity;
import com.example.testeProva.Repositories.ResponsaveisRepository;
import com.example.testeProva.Repositories.TarefasRepository;
import com.example.testeProva.Repositories.UsuariosRepository;
import com.example.testeProva.dtos.req.CreateTarefaDTO;
import com.example.testeProva.dtos.req.CreateUsuarioDTO;
import com.example.testeProva.dtos.res.ShowResponsavelDTO;
import com.example.testeProva.dtos.res.ShowTarefaDTO;
import com.example.testeProva.dtos.res.ShowUsuarioDTO;
import com.example.testeProva.enums.Especialidade;
import com.example.testeProva.models.Joao;
import com.example.testeProva.models.Responsavel;
import com.example.testeProva.models.Tarefa;
import com.example.testeProva.models.Usuario;

import jakarta.transaction.Transactional;

@Service
public class TarefasService {

  @Autowired
  TarefasRepository tarefasRepository;

  @Autowired
  ResponsaveisRepository responsaveisRepository;

  @Autowired
  UsuariosRepository usuariosRepository;

  @Transactional
  public void createTarefa(Tarefa tarefa) {

    TarefasEntity tarefasEntity = new TarefasEntity();
    tarefasEntity.setTitulo(tarefa.getTitulo()); // Alterado de "setNome" para "setTitulo"

    tarefasEntity = tarefasRepository.save(tarefasEntity);

    ResponsaveisEntity responsaveisEntity = new ResponsaveisEntity();
    responsaveisEntity.setNome(tarefa.getResposavel().getNome());
    responsaveisEntity.setEmail(tarefa.getResposavel().getEmail());
    responsaveisEntity.setTarefa(tarefasEntity);

    responsaveisEntity = responsaveisRepository.save(responsaveisEntity);

    List<UsuariosEntity> usuariosEntity = new ArrayList<>();

    for (Usuario usuario : tarefa.getUsuarios()) {
        UsuariosEntity usuarioEntity = new UsuariosEntity();
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());

        if (usuario instanceof Joao) {
            usuarioEntity.setTipo("Joao");
        }



        usuarioEntity.setTarefa(tarefasEntity);

        usuariosEntity.add(usuarioEntity);
    }

    usuariosRepository.saveAll(usuariosEntity);
}


public List<ShowTarefaDTO> getAllTarefas() {
  List<TarefasEntity> tarefasEntity = tarefasRepository.findAll();

  return tarefasEntity.stream().map(tarefa -> {
      ShowTarefaDTO tarefaDTO = new ShowTarefaDTO();
      ShowResponsavelDTO responsavelDTO = new ShowResponsavelDTO();
      List<ShowUsuarioDTO> usuariosDTO = new ArrayList<>();

      // Verifica se a tarefa tem um responsável
      if (tarefa.getResponsavel() != null) {
          responsavelDTO.setNome(tarefa.getResponsavel().getNome());
          responsavelDTO.setEmail(tarefa.getResponsavel().getEmail());
          tarefaDTO.setResponsavel(responsavelDTO);
      } else {
          responsavelDTO.setNome("Sem Responsável");
          responsavelDTO.setEmail("");
          tarefaDTO.setResponsavel(responsavelDTO);
      }

      for (UsuariosEntity usuarioEntity : tarefa.getUsuarios()) {
          ShowUsuarioDTO usuarioDTO = new ShowUsuarioDTO();
          usuarioDTO.setNome(usuarioEntity.getNome());
          usuarioDTO.setEmail(usuarioEntity.getEmail());
          usuariosDTO.add(usuarioDTO);
      }

      tarefaDTO.setId(tarefa.getId());
      tarefaDTO.setTitulo(tarefa.getTitulo());
      tarefaDTO.setUsuarios(usuariosDTO);

      return tarefaDTO;
  }).toList();
}

public Tarefa getTarefaById(Long id) {

Optional<TarefasEntity> optionalTarefa = tarefasRepository.findById(id);

if (optionalTarefa.isEmpty()) {
		// jogar uma execução
	}
	
	TarefasEntity tarefasEntity = optionalTarefa.get();
	
	Tarefa tarefa = new Tarefa();

    tarefa.setId(tarefasEntity.getId());
    tarefa.setTitulo(tarefasEntity.getTitulo());

    Especialidade especialidade = Especialidade.valueOf(tarefasEntity.getEspecialidade());

    tarefa.setEspecialidade(especialidade);

    Responsavel responsavel = new Responsavel();
    responsavel.setNome(tarefasEntity.getResponsavel().getNome());
    responsavel.setEmail(tarefasEntity.getResponsavel().getEmail());

    tarefa.setResposavel(responsavel);

    for (UsuariosEntity entity : tarefasEntity.getUsuarios()) {
        Usuario usuario = null;

        if (entity.getTipo)
    }

	return tarefa;
}

}

// departamento = responsavel
// funcionario = tarefa
// projeto = usuario