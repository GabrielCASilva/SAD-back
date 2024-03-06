package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.api.dto.FuncionarioDTO;
import com.trabalho.sad.api.dto.SetorDTO;
import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.Setor;
import com.trabalho.sad.model.repository.SetorRepository;
import com.trabalho.sad.service.SetorService;

@Service
public class SetorServiceImpl implements SetorService{
	
		/* Acesso aos métodos de persistência JPA para setores
		 * */
	private SetorRepository setorRepository;
	
	/* Construtor 
	 ***************************************************************************************************/
	public SetorServiceImpl(SetorRepository setorRepo) {
		this.setorRepository = setorRepo;
	}


	/* Métodos 
	 ***************************************************************************************************/
	@Override
	@Transactional
	public Setor cadastrar(Setor setorParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(setorParam.getId());
		return setorRepository.save(setorParam);
	}

	@Override
	@Transactional
	public Setor atualizar(Setor setorParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(setorParam.getId());
		return setorRepository.save(setorParam);
	}

	@Override
	@Transactional
	public void deletar(Setor setorParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(setorParam.getId());
		setorRepository.delete(setorParam);
	}
	
	@Override
	@Transactional
	public List<Setor> buscar(Setor setorParamFiltro) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(setorParamFiltro.getId());
		Example<Setor> exampleSetor = Example.of(setorParamFiltro);
		return setorRepository.findAll(exampleSetor);
	}


	@Override
	@Transactional
	public Optional<Setor> consultarPorId(Long id) {
		return setorRepository.findById(id);
	}

	@Override
	@Transactional
	public List<SetorDTO> findAll() {	
			/* Verifica que o parâmetro recebido não é nulo
			* */
		List<Setor> setores = setorRepository.findAll();
		List<SetorDTO> setorDTO = setores.stream()
				.map(SetorDTO::new)
				.collect(Collectors.toList());
		return setorDTO;
	}

}
