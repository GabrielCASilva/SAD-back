package com.trabalho.sad.service;

import java.util.List;

import com.trabalho.sad.model.entities.Meta;

public interface MetaService {
	
	Meta cadastrar(Meta metaParam);
	
	Meta atualizar(Long id, Meta metaParam);
	
	Meta inativar(Meta metaParam);
	
	List<Meta> buscar();
	
	Meta consultarPorId(Long id);
}
