package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Tarefa;
import com.trabalho.sad.model.entities.status.SituacaoServico;
import com.trabalho.sad.model.repository.TarefaRepository;
import com.trabalho.sad.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	/*
	 * Acesso aos métodos de persistência JPA para tarefas
	 */
	private TarefaRepository tarefaRepository;

	/*
	 * Construtor
	 ***************************************************************************************************/
	public TarefaServiceImpl(TarefaRepository tarefaRepo) {
		this.tarefaRepository = tarefaRepo;
	}

	/*
	 * Métodos
	 ***************************************************************************************************/
	@Override
	@Transactional
	public Tarefa cadastrar(Tarefa tarefaParam) {
		/*
		 * Verifica que o parâmetro recebido não é nulo
		 */
		Objects.requireNonNull(tarefaParam.getId());
		return tarefaRepository.save(tarefaParam);
	}

	@Override
	@Transactional
	public Tarefa atualizar(Tarefa tarefaParam) {
		/*
		 * Verifica que o parâmetro recebido não é nulo
		 */
		Objects.requireNonNull(tarefaParam.getId());
		return tarefaRepository.save(tarefaParam);
	}

	/*
	 * Tarefas não serão deletadas. Ao invés disto, a situação da tarefa é
	 * marcada como 'Inativa'
	 */
	@Override
	@Transactional
	public Tarefa inativar(Tarefa tarefaParam) {
		/*
		 * Para inativar, a situação da tarefa deve ser 'Inativa'.
		 */
		tarefaParam.setSituacao(SituacaoServico.INATIVA.toString());
		return tarefaRepository.save(tarefaParam);
	}

	@Override
	@Transactional
	public List<Tarefa> buscar(Tarefa tarefaParamFiltro) {
		/*
		 * Verifica que o parâmetro recebido não é nulo
		 */
		Objects.requireNonNull(tarefaParamFiltro.getId());
		Example<Tarefa> exampleTarefa = Example.of(tarefaParamFiltro);
		return tarefaRepository.findAll(exampleTarefa);
	}

	@Override
	@Transactional
	public Optional<Tarefa> consultarPorId(Long id) {
		return tarefaRepository.findById(id);
	}

}
