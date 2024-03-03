package com.trabalho.sad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trabalho.sad.api.dto.CargoDTO;
import com.trabalho.sad.model.entities.Cargo;

public interface CargoService {
	
	Cargo cadastrar(Cargo cargoParam);
	
	Cargo atualizar(Cargo cargoParam);
	
	void deletar(Cargo cargoParam);
	
	Page<CargoDTO> buscar(Pageable pageable);
	
	Optional<Cargo> consultarPorId(Long id);

	List<CargoDTO> findAll(Long id);
}
