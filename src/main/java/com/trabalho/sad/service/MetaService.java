package com.trabalho.sad.service;

import java.util.List;
import java.util.Optional;

import com.trabalho.sad.api.dto.MetaDTO;
import com.trabalho.sad.model.entities.Meta;

public interface MetaService {
	
	Meta cadastrar(Meta metaParam);
	
	Meta atualizar(Meta metaParam);
	
	Meta inativar(Meta metaParam);
	
	List<MetaDTO> buscar();
	
	Optional<Meta> consultarPorId(Long id);

}
