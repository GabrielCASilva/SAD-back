package com.trabalho.sad.service;

import java.util.List;

import com.trabalho.sad.model.entities.Cargo;

public interface CargoService {
	
	Cargo cadastrar(Cargo cargoParam);
	
	Cargo atualizar(Long id, Cargo cargoParam);
	
	void deletar(Cargo cargoParam);
	
	List<Cargo> buscar();
	
	Cargo consultarPorId(Long id);

}
