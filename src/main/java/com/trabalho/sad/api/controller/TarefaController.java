package com.trabalho.sad.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.sad.api.dto.AvaliacaoDTO;
import com.trabalho.sad.api.dto.TarefaDTO;
import com.trabalho.sad.exceptions.RegraNegocioException;
import com.trabalho.sad.model.entities.AvaliacaoExecutor;
import com.trabalho.sad.model.entities.AvaliacaoSuperior;
import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.model.entities.ProgressoMeta;
import com.trabalho.sad.model.entities.Tarefa;
import com.trabalho.sad.service.FuncionarioService;
import com.trabalho.sad.service.MetaService;
import com.trabalho.sad.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;
	
	@Autowired
	MetaService metaService;
	
	@Autowired
	FuncionarioService funcionarioService;

	private Tarefa converter(TarefaDTO dto) {
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(dto.getNome());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.setDataCriacao(dto.getDataCriacao());
		tarefa.setDataPrevistaConclusao(dto.getDataPrevistaConclusao());
		tarefa.setDataInicio(dto.getDataInicio());
		tarefa.setDataConclusao(dto.getDataConclusao());
		tarefa.setTaxaProgresso(dto.getTaxaProgresso());
		tarefa.setSituacao(dto.getSituacao());
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
	
    @GetMapping(value = "/servidor/{servidorId}")
    public ResponseEntity<AvaliacaoDTO> obterTarefasServidorPorPeriodo(
            @PathVariable Long servidorId,
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        Funcionario servidor = funcionarioService.consultarPorId(servidorId);
        List<Tarefa> tarefas = tarefaService.obterTarefasServidorPorPeriodo(servidor, dataInicio, dataFim);

		AvaliacaoExecutor avaliacao = new AvaliacaoExecutor(servidor, tarefas);
		avaliacao.calcularAvaliacao();
		AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(avaliacao.getIndiceProdutividade(), 
			avaliacao.getIndiceAgilidade(), avaliacao.getIndiceEficacia(), avaliacao.getIndiceComprometimento(), tarefas);

        return ResponseEntity.ok(avaliacaoDTO);
    }
    
    @GetMapping(value = "/supervisor/{supervisorId}")
    public ResponseEntity<AvaliacaoDTO> obterTarefasSupervisorPorPeriodo(
            @PathVariable Long supervisorId,
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        Funcionario supervisor = funcionarioService.consultarPorId(supervisorId);           
        List<Tarefa> tarefas = tarefaService.obterTarefasSupervisorPorPeriodo(supervisor, dataInicio, dataFim);

		AvaliacaoSuperior avaliacao = new AvaliacaoSuperior(supervisor, tarefas);
		avaliacao.calcularAvaliacao();
		AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(avaliacao.getIndiceProdutividade(), 
			avaliacao.getIndiceAgilidade(), avaliacao.getIndiceEficacia(), avaliacao.getIndiceComprometimento(), tarefas);

        return ResponseEntity.ok(avaliacaoDTO);
    }
    
    @GetMapping(value = "/meta/{metaId}")
    public ResponseEntity<AvaliacaoDTO> obterTarefasDaMetaNoPeriodo(
            @PathVariable Long metaId,
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        Meta meta = metaService.consultarPorId(metaId);           
        List<Tarefa> tarefas = tarefaService.obterTarefasDaMetaNoPeriodo(meta, dataInicio, dataFim);

		ProgressoMeta progresso = new ProgressoMeta(meta, tarefas);
		progresso.calcularAvaliacao();
		AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(progresso.getIndiceProdutividade(), 
			progresso.getIndiceAgilidade(), progresso.getIndiceEficacia(), tarefas);
			
        return ResponseEntity.ok(avaliacaoDTO);
    }
}
