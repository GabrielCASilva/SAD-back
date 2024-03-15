package com.trabalho.sad.service;

import java.util.List;

import com.trabalho.sad.model.entities.Tarefa;

public interface TarefaService {
	
	Tarefa cadastrar(Tarefa tarefaParam);
	
	Tarefa atualizar(Long id, Tarefa tarefaParam);
	
	Tarefa inativar(Tarefa tarefaParam);
	
	List<Tarefa> buscar();
	
	Tarefa consultarPorId(Long id);
}
