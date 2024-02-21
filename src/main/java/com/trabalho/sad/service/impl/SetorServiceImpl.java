package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Setor> buscar() {
		
		return setorRepository.findAll();
	}

}
