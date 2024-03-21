package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.model.repository.MetaRepository;
import com.trabalho.sad.service.MetaService;

@Service
public class MetaServiceImpl implements MetaService{
	
	@Autowired
	private MetaRepository metaRepository;
	

	@Override
	@Transactional
	public Meta cadastrar(Meta metaParam) {
		Objects.requireNonNull(metaParam.getId());
		return metaRepository.save(metaParam);
	}

	@Override
	@Transactional
	public Meta atualizar(Long id, Meta obj) {
		Meta entity = metaRepository.getReferenceById(id);
		atualizarDados(entity, obj);
		Objects.requireNonNull(entity.getId());
		return metaRepository.save(entity);
	}

	public Meta atualizarDados(Meta entity, Meta obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		entity.setDataCriacao(obj.getDataCriacao());
		entity.setDataPrevistaConclusao(obj.getDataPrevistaConclusao());
		entity.setDataConclusao(obj.getDataConclusao());
		entity.setSituacao(obj.getSituacao());
		return(entity);
	}
	
	@Override
	@Transactional
	public Meta inativar(Meta metaParam) {
		//TODO
		return metaRepository.save(metaParam);
	}

	@Override
	@Transactional
	public List<Meta> buscar() {	
		return metaRepository.findAll();
	}

	@Override
	public Meta consultarPorId(Long id) {
		Optional<Meta> obj = metaRepository.findById(id);
		return obj.get();
	}
}
