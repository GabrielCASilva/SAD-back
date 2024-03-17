package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.model.repository.CargoRepository;
import com.trabalho.sad.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService{
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Override
	@Transactional
	public Cargo cadastrar(Cargo cargoParam) {
		Objects.requireNonNull(cargoParam.getId());
		return cargoRepository.save(cargoParam);
	}

	@Transactional
	public Cargo atualizar(Long id, Cargo obj) {
		Cargo entity = cargoRepository.getReferenceById(id);
		atualizarDados(entity, obj);
		Objects.requireNonNull(entity.getId());
		return cargoRepository.save(entity);
	}

	public Cargo atualizarDados(Cargo entity, Cargo obj) {
		entity.setNome(obj.getNome());
		entity.setTipoAvaliacao(obj.getTipoAvaliacao());
		return(entity);
	}

	@Override
	@Transactional
	public void deletar(Cargo cargoParam) {
		Objects.requireNonNull(cargoParam.getId());
		cargoRepository.delete(cargoParam);
	}

	@Override
	@Transactional
	public List<Cargo> buscar() {
		return cargoRepository.findAll();
	}
	
	@Override
	@Transactional
	public Cargo consultarPorId(Long id) {
		Optional<Cargo> obj = cargoRepository.findById(id);
		return obj.get();
	}
}
