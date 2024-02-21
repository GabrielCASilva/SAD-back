package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.SituacaoServico;
import com.trabalho.sad.model.repository.SituacaoServicoRepository;
import com.trabalho.sad.service.SituacaoServicoService;

@Service
public class SituacaoServicoServiceImpl implements SituacaoServicoService{
	
		/* Acesso aos métodos de persistência JPA para situações de serviço
		 * */
	private SituacaoServicoRepository situacaoServicoRepository;
	
	/* Construtor 
	 ***************************************************************************************************/
	public SituacaoServicoServiceImpl(SituacaoServicoRepository situacaoServicoRepo) {
		this.situacaoServicoRepository = situacaoServicoRepo;
	}
	

	/* Métodos 
	 ***************************************************************************************************/
	@Override
	@Transactional
	public SituacaoServico cadastrar(SituacaoServico situacaoServicoParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(situacaoServicoParam.getId());
		return situacaoServicoRepository.save(situacaoServicoParam);
	}

	@Override
	@Transactional
	public SituacaoServico atualizar(SituacaoServico situacaoServicoParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(situacaoServicoParam.getId());
		return situacaoServicoRepository.save(situacaoServicoParam);
	}

	@Override
	@Transactional
	public void deletar(SituacaoServico situacaoServicoParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(situacaoServicoParam.getId());
		situacaoServicoRepository.delete(situacaoServicoParam);
	}

	@Override
	@Transactional
	public List<SituacaoServico> buscar(SituacaoServico situacaoServicoParamFiltro) {	
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(situacaoServicoParamFiltro.getId());
		Example<SituacaoServico> exampleSituacaoServico = Example.of(situacaoServicoParamFiltro);
		return situacaoServicoRepository.findAll(exampleSituacaoServico);
	}


}
