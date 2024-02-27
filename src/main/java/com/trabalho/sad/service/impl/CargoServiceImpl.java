package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.model.repository.CargoRepository;
import com.trabalho.sad.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService{
	
		/* Acesso aos métodos de persistência JPA para cargos
		 * */
	private CargoRepository cargoRepository;

	/* Construtor 
	 ***************************************************************************************************/
	public CargoServiceImpl(CargoRepository cargoRepo) {
		this.cargoRepository = cargoRepo;
	}
	
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
	@Transactional
	public List<Cargo> buscar(Cargo cargoParamFiltro) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(cargoParamFiltro.getId());
		Example<Cargo> exampleCargo = Example.of(cargoParamFiltro);
		return cargoRepository.findAll(exampleCargo);
	}

	@Override
	@Transactional
	public Optional<Cargo> consultarPorId(Long id) {
		return cargoRepository.findById(id);
	}

}
