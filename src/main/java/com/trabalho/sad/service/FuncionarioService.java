package com.trabalho.sad.service;

import java.util.List;

import com.trabalho.sad.model.entities.Funcionario;

public interface FuncionarioService {
	
	Funcionario cadastrar(Funcionario funcionarioParam);
	
	Funcionario atualizar(Funcionario funcionarioParam);
	
	Funcionario inativar(Funcionario funcionarioParam);
	
	List<Funcionario> buscar(Funcionario funcionarioParam);

}
