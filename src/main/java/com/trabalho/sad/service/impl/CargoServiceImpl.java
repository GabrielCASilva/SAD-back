package com.trabalho.sad.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.api.dto.CargoDTO;
import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.model.repository.CargoRepository;
import com.trabalho.sad.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService{
	
		/* Acesso aos métodos de persistência JPA para cargos
		 * */
	@Autowired
	private CargoRepository cargoRepository;

	/* Métodos 
	 ***************************************************************************************************/
	@Override
	@Transactional
	public Cargo cadastrar(Cargo cargoParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(cargoParam.getId());
		return cargoRepository.save(cargoParam);
	}

	@Override
	@Transactional
	public Cargo atualizar(Cargo cargoParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(cargoParam.getId());
		return cargoRepository.save(cargoParam);
	}

	@Override
	@Transactional
	public void deletar(Cargo cargoParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(cargoParam.getId());
		cargoRepository.delete(cargoParam);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CargoDTO> buscar(Pageable pageable) {
		Page<Cargo> result = cargoRepository.findAll(pageable);
		return result.map(x -> new CargoDTO(x));
	}

	@Override
	@Transactional(readOnly = true)
	public List<CargoDTO> findAll(Long id) {

		List<Cargo> result;

		if(id != null){
			result = cargoRepository.findAllById(id);
		}else{
			result = cargoRepository.findAll();
		}

		List<CargoDTO> cargoDTOs = new ArrayList<>();
		for (Cargo cargo : result) {
			cargoDTOs.add(new CargoDTO(cargo));
		}

		return cargoDTOs;
	}

	@Override
	@Transactional
	public Optional<Cargo> consultarPorId(Long id) {
		return cargoRepository.findById(id);
	}

}
