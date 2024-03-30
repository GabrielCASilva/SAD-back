package com.trabalho.sad.service;

import java.util.List;

import com.trabalho.sad.model.entities.Funcionario;

public interface FuncionarioService {
	
	Funcionario cadastrar(Funcionario funcionario);
	
	Funcionario atualizar(Long id, Funcionario funcionario);
	
	Funcionario inativar(Funcionario funcionario);
	
	List<Funcionario> buscar();
	
	Funcionario consultarPorId(Long id);	
}
