package com.trabalho.sad.service;

import java.util.List;
import java.util.Optional;

import com.trabalho.sad.api.dto.SetorDTO;
import com.trabalho.sad.model.entities.Setor;

public interface SetorService {

	Setor cadastrar(Setor setorParam);
	
	Setor atualizar(Setor setorParam);
	
	void deletar(Setor setorParam);
	
	List<Setor> buscar(Setor setorParam);

	List<SetorDTO> findAll();
	
	Optional<Setor> consultarPorId(Long id);
}
