package com.trabalho.sad.service;

import java.util.List;

import com.trabalho.sad.model.entities.SituacaoFuncionario;

public interface SituacaoFuncionarioService {

	SituacaoFuncionario cadastrar(SituacaoFuncionario situacaoFuncionarioParam);
	
	SituacaoFuncionario atualizar(SituacaoFuncionario situacaoFuncionarioParam);
	
	void deletar(SituacaoFuncionario situacaoFuncionarioParam);
	
	List<SituacaoFuncionario> buscar(SituacaoFuncionario situacaoFuncionarioParam);
}
