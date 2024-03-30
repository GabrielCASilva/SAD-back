package com.trabalho.sad.service;

import java.util.List;

import com.trabalho.sad.model.entities.Setor;

public interface SetorService {

	Setor cadastrar(Setor setorParam);
	
	Setor atualizar(Long id, Setor obj);
	
	void deletar(Setor setorParam);
	
	List<Setor> buscar();
	
	Setor consultarPorId(Long id);
}
