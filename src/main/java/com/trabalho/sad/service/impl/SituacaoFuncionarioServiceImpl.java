package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.SituacaoFuncionario;
import com.trabalho.sad.model.repository.SituacaoFuncionarioRepository;
import com.trabalho.sad.service.SituacaoFuncionarioService;

@Service
public class SituacaoFuncionarioServiceImpl implements SituacaoFuncionarioService{
	
		/* Acesso aos métodos de persistência JPA para situações de funcionários
		 * */
	private SituacaoFuncionarioRepository situacaoFuncionarioRepository;
	
	/* Construtor 
	 ***************************************************************************************************/
	public SituacaoFuncionarioServiceImpl(SituacaoFuncionarioRepository situacaoFuncionarioRepo) {
		this.situacaoFuncionarioRepository = situacaoFuncionarioRepo;
	}

	
	/* Métodos 
	 ***************************************************************************************************/
	@Override
	@Transactional
	public SituacaoFuncionario cadastrar(SituacaoFuncionario situacaoFuncionarioParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(situacaoFuncionarioParam.getId());
		return situacaoFuncionarioRepository.save(situacaoFuncionarioParam);
	}

	@Override
	@Transactional
	public SituacaoFuncionario atualizar(SituacaoFuncionario situacaoFuncionarioParam) {
		/* Verifica que o parâmetro recebido não é nulo
		 * */
	Objects.requireNonNull(situacaoFuncionarioParam.getId());
	return situacaoFuncionarioRepository.save(situacaoFuncionarioParam);
	}

	@Override
	@Transactional
	public void deletar(SituacaoFuncionario situacaoFuncionarioParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(situacaoFuncionarioParam.getId());
		situacaoFuncionarioRepository.delete(situacaoFuncionarioParam);
	}

	@Override
	@Transactional
	public List<SituacaoFuncionario> buscar(SituacaoFuncionario situacaoFuncionarioParamFiltro) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(situacaoFuncionarioParamFiltro.getId());
		Example<SituacaoFuncionario> exampleSituacaoFuncionario = Example.of(situacaoFuncionarioParamFiltro);
		return situacaoFuncionarioRepository.findAll(exampleSituacaoFuncionario);
	}

}
