package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.model.repository.MetaRepository;
import com.trabalho.sad.service.MetaService;

@Service
public class MetaServiceImpl implements MetaService{
	
		/* Acesso aos métodos de persistência JPA para metas
		 * */
	private MetaRepository metaRepository;
	
	/* Construtor 
	 ***************************************************************************************************/
	public MetaServiceImpl(MetaRepository metaRepo) {
		this.metaRepository = metaRepo;
	}

	/* Métodos 
	 ***************************************************************************************************/
	@Override
	@Transactional
	public Meta cadastrar(Meta metaParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(metaParam.getId());
		return metaRepository.save(metaParam);
	}

	@Override
	@Transactional
	public Meta atualizar(Meta metaParam) {
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(metaParam.getId());
		return metaRepository.save(metaParam);
	}

		/* Metas não serão deletadas. Ao invés disto, a situação do meta é 
		 * marcada como 'inativo' 
		 * */
	@Override
	@Transactional
	public Meta inativar(Meta metaParam) {
			/* Para inativar, a situação da meta deve ser 'inativo'.
			 * Se não for, mudamos para 'inativo'.
			 * */
		//TODO
		return metaRepository.save(metaParam);
	}

	@Override
	@Transactional
	public List<Meta> buscar(Meta metaParamFiltro) {	
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(metaParamFiltro.getId());
		Example<Meta> exampleMeta = Example.of(metaParamFiltro);
		return metaRepository.findAll(exampleMeta);
	}

}
