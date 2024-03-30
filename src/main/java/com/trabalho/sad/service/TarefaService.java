package com.trabalho.sad.service;

import java.time.LocalDate;
import java.util.List;

import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.model.entities.Tarefa;

public interface TarefaService {

	Tarefa cadastrar(Tarefa tarefaParam);

	Tarefa atualizar(Long id, Tarefa tarefaParam);

	Tarefa inativar(Tarefa tarefaParam);

	List<Tarefa> buscar();

	Tarefa consultarPorId(Long id);

	List<Tarefa> obterTarefasServidorPorPeriodo(Funcionario servidor, LocalDate dataInicio, LocalDate dataFim);
	
	List<Tarefa> obterTarefasSupervisorPorPeriodo(Funcionario supervisor, LocalDate dataInicio, LocalDate dataFim);
	
	List<Tarefa> obterTarefasDaMetaNoPeriodo(Meta meta, LocalDate dataInicio, LocalDate dataFim);
}
