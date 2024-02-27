package com.trabalho.sad.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.sad.api.dto.TarefaDTO;
import com.trabalho.sad.exceptions.SadException;
import com.trabalho.sad.model.entities.Tarefa;
import com.trabalho.sad.service.TarefaService;

/* http://localhost:8080/api/funcionarios
 * */
@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
	
	TarefaService service;
	
	/* Construtor 
	 ***************************************************************************************************/
	public TarefaController(TarefaService service) {
		this.service = service;
	}
	
	
	/* Métodos 
	 ***************************************************************************************************/
	
		/* Conversor de objetos DTO em Entidades
		 * */
	private Tarefa converter(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa();
		
		tarefa.setNome(dto.getNome());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.setDataCriacao(dto.getDataConclusao());
		tarefa.setDataPrevistaConclusao(dto.getDataConclusao());
		tarefa.setDataInicio(dto.getDataInicio());
		tarefa.setDataConclusao(dto.getDataConclusao());
		tarefa.setTaxaProgresso(dto.getTaxaProgresso());
		tarefa.setSituacao(dto.getSituacao());
		
		if(dto.getId() != null) {
			tarefa.setId(dto.getId());
		}
		
		return tarefa;
	}
	
		/* http://localhost:8080/api/tarefas/cadastrar
		 * */
	//TODO Proteger
	//	1) Data prevista de conclusao deve ser maior que data de criacao
	//	2) Data de conclusao deve ser maior que data de criacao
	//	3) Data de início deve ser maior que data de criacao
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrar( @RequestBody TarefaDTO dto) {
		try {
			Tarefa entidadeTarefa = this.converter(dto);
			entidadeTarefa = this.service.cadastrar(entidadeTarefa);
			return ResponseEntity.ok(entidadeTarefa);
		} catch (SadException sadException) {
			return ResponseEntity.badRequest().body(sadException.getMessage());
		}
	}
	
		/* http://localhost:8080/api/tarefas/atualizar/{id}
		 * */
	//TODO Proteger
		//	1) Não pode mudar data de criação
		//	2) Data prevista de conclusao deve ser maior que data de criacao
		//	3) Data de conclusao deve ser maior que data de criacao
		//	4) Data de início deve ser maior que data de criacao
	@PutMapping("/atualizar/{id}")
	public ResponseEntity atualizar( @PathVariable("id") Long id, @RequestBody TarefaDTO dto) {
		return service.consultarPorId(id).map(
					entity -> {
						try {
					/* Tarefa encontrada
					 * */
							Tarefa tarefa = this.converter(dto);
							tarefa.setId(entity.getId());
							service.atualizar(tarefa);
							return ResponseEntity.ok(tarefa);
						} catch (SadException sadException) {
					/* Tarefa encontrada, porém erro na manipulação
					 * */
							return ResponseEntity.badRequest().body(sadException.getMessage());
						}
					}
				).orElseGet(
					/* Tarefa não encontrada
					 * */
						() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar uma "
								+ "tarefa com o ID informado.")
						);
	}
	
		/* http://localhost:8080/api/tarefas/inativar/{id}
		 * */
	@PutMapping("/inativar/{id}")
	public ResponseEntity inativar( @PathVariable("id") Long id, @RequestBody TarefaDTO dto) {
		return service.consultarPorId(id).map(
					entity -> {
						try {
					/* Tarefa encontrada
					 * */
							Tarefa tarefa = this.converter(dto);
							tarefa.setId(entity.getId());
							service.inativar(tarefa);
							return ResponseEntity.ok(tarefa);
						} catch (SadException sadException) {
					/* Tarefa encontrada, porém erro na manipulação
					 * */
							return ResponseEntity.badRequest().body(sadException.getMessage());
						}
					}
				).orElseGet(
					/* Tarefa não encontrada
					 * */
						() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar uma "
								+ "tarefa com o ID informado, logo a inativação não pode ser realizada.")
						);
	}
	
		/* http://localhost:8080/api/tarefas/buscar
		 * */
	@GetMapping("/buscar")
	public ResponseEntity buscar(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "situacao", required = false) String situacao
			
			) {
		Tarefa tarefaFiltro = new Tarefa();
		tarefaFiltro.setId(id);
		tarefaFiltro.setNome(nome);
		tarefaFiltro.setSituacao(situacao);
		
		List<Tarefa> tarefas = service.buscar(tarefaFiltro);
		return ResponseEntity.ok(tarefas);
	}

}
