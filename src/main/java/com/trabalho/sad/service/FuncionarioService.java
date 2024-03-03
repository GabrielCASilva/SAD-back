package com.trabalho.sad.service;

import java.util.List;
import java.util.Optional;

import com.trabalho.sad.api.dto.FuncionarioDTO;
import com.trabalho.sad.model.entities.Funcionario;

public interface FuncionarioService {
	
	Funcionario cadastrar(Funcionario funcionarioParam);
	
	Funcionario atualizar(Funcionario funcionarioParam);
	
	Funcionario inativar(Funcionario funcionarioParam);
	
	List<FuncionarioDTO> buscar();
	
	Optional<Funcionario> consultarPorId(Long id);

}
