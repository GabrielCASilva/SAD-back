package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Setor;
import com.trabalho.sad.model.repository.SetorRepository;
import com.trabalho.sad.service.SetorService;

@Service
public class SetorServiceImpl implements SetorService{

	@Autowired
	private SetorRepository setorRepository;

	@Override
	@Transactional
	public Setor cadastrar(Setor setorParam) {
		Objects.requireNonNull(setorParam.getId());
		return setorRepository.save(setorParam);
	}
	
	@Override
	@Transactional
	public Setor atualizar(Long id, Setor obj) {
		Setor entity = setorRepository.getReferenceById(id);
		atualizarDados(entity, obj);
		Objects.requireNonNull(entity.getId());
		return setorRepository.save(entity);
	}

	public Setor atualizarDados(Setor entity, Setor obj) {
		entity.setNome(obj.getNome());
		entity.setLocalizacao(obj.getLocalizacao());
		entity.setRamal(obj.getRamal());
		entity.setSupervisor(obj.getSupervisor());
		return(entity);
	}

	@Override
	@Transactional
	public void deletar(Setor setorParam) {
		Objects.requireNonNull(setorParam.getId());
		setorRepository.delete(setorParam);
	}
	
	@Override
	@Transactional
	public List<Setor> buscar() {		
		return setorRepository.findAll();
	}

	@Override
	@Transactional
	public Setor consultarPorId(Long id) {
		Optional<Setor> obj = setorRepository.findById(id);
		return obj.get();
	}	
}
