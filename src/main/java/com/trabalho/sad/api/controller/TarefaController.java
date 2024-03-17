package com.trabalho.sad.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.sad.api.dto.TarefaDTO;
import com.trabalho.sad.exceptions.RegraNegocioException;
import com.trabalho.sad.model.entities.Tarefa;
import com.trabalho.sad.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;

	private Tarefa converter(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(dto.getNome());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.setDataCriacao(dto.getDataCriacao());
		tarefa.setDataPrevistaConclusao(dto.getDataPrevistaConclusao());
		tarefa.setDataInicio(dto.getDataInicio());
		tarefa.setDataConclusao(dto.getDataConclusao());
		tarefa.setTaxaProgresso(dto.getTaxaProgresso());		
		return tarefa;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody TarefaDTO dto) {
		try {
			Tarefa obj = converter(dto);
			obj = tarefaService.cadastrar(obj);
			return ResponseEntity.ok(obj);
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody TarefaDTO dto) {
		Tarefa obj = converter(dto);
		obj = tarefaService.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> buscar() {
		List<Tarefa> list = tarefaService.buscar();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> consultarPorId(@PathVariable Long id) {
		Tarefa obj = tarefaService.consultarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
