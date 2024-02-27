package com.trabalho.sad.service;

import java.util.List;
import java.util.Optional;

import com.trabalho.sad.model.entities.Tarefa;

public interface TarefaService {
	
	Tarefa cadastrar(Tarefa tarefaParam);
	
	Tarefa atualizar(Tarefa tarefaParam);
	
	Tarefa inativar(Tarefa tarefaParam);
	
	List<Tarefa> buscar(Tarefa tarefaParam);
	
	Optional<Tarefa> consultarPorId(Long id);

}
