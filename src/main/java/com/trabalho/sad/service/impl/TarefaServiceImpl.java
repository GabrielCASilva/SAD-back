package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Tarefa;
import com.trabalho.sad.model.repository.TarefaRepository;
import com.trabalho.sad.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService{
	
	@Autowired
	private TarefaRepository tarefaRepository;
	

	@Override
	@Transactional
	public Tarefa cadastrar(Tarefa tarefaParam) {	
		Objects.requireNonNull(tarefaParam.getId());
		return tarefaRepository.save(tarefaParam);
	}

	@Override
	@Transactional
	public Tarefa atualizar(Long id, Tarefa obj) {
		Tarefa entity = tarefaRepository.getReferenceById(id);
		atualizarDados(entity, obj);
		Objects.requireNonNull(entity.getId());
		return tarefaRepository.save(entity);
	}

	public Tarefa atualizarDados(Tarefa entity, Tarefa obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		entity.setDataCriacao(obj.getDataCriacao());
		entity.setDataPrevistaConclusao(obj.getDataPrevistaConclusao());
		entity.setDataInicio(obj.getDataInicio());
		entity.setDataConclusao(obj.getDataConclusao());
		entity.setTaxaProgresso(obj.getTaxaProgresso());
		entity.setSituacao(obj.getSituacao());
		return(entity);
	}
	
	@Override
	@Transactional
	public Tarefa inativar(Tarefa tarefaParam) {
		return tarefaRepository.save(tarefaParam);
	}

	@Override
	@Transactional
	public List<Tarefa> buscar() {	
		return tarefaRepository.findAll();
	}
	
	@Override
	@Transactional
	public Tarefa consultarPorId(Long id) {
		Optional<Tarefa> obj = tarefaRepository.findById(id);
		return obj.get();
	}
}
