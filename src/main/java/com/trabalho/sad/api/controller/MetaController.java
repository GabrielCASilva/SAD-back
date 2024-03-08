package com.trabalho.sad.api.controller;

import java.util.List;

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

import com.trabalho.sad.api.dto.MetaDTO;
import com.trabalho.sad.exceptions.SadException;
import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.service.MetaService;

	/* http://localhost:8080/api/metas
	 * */
@RestController
@RequestMapping("/api/metas")
@CrossOrigin(origins = "*")
public class MetaController {
	
	MetaService service;
	
	/* Construtor 
	 ***************************************************************************************************/
	public MetaController(MetaService service) {
		this.service = service;
	}

	
	/* Métodos 
	 ***************************************************************************************************/
	
		/* Conversor de objetos DTO em Entidades
		 * */
	private Meta converter(MetaDTO dto) {
		Meta meta = new Meta();
		
		meta.setNome(dto.getNome());
		meta.setDescricao(dto.getDescricao());
		meta.setDataCriacao(dto.getDataCriacao());
		meta.setDataPrevistaConclusao(dto.getDataPrevistaConclusao());
		meta.setDataConclusao(dto.getDataConclusao());
		meta.setSituacao(dto.getSituacao());
		
		if(dto.getId() != null) {
			meta.setId(dto.getId());
		}
		
		return meta;
	}

		/* http://localhost:8080/api/metas/cadastrar
		 * */
	//TODO Proteger
	//	1) Data prevista de conclusao deve ser maior que data de criacao
	//	2) Data de conclusao deve ser maior que data de criacao
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrar( @RequestBody MetaDTO dto) {
		try {
			Meta entidadeMeta = this.converter(dto);
			entidadeMeta = this.service.cadastrar(entidadeMeta);
			return ResponseEntity.ok(entidadeMeta);
		} catch (SadException sadException) {
			return ResponseEntity.badRequest().body(sadException.getMessage());
		}
	}
	
		/* http://localhost:8080/api/metas/atualizar/{id}
		 * */
	//TODO Proteger
	//	1) Não pode mudar data de criação
	//	2) Data prevista de conclusao deve ser maior que data de criacao
	//	3) Data de conclusao deve ser maior que data de criacao
	@PutMapping("/atualizar/{id}")
	public ResponseEntity atualizar( @PathVariable("id") Long id, @RequestBody MetaDTO dto) {
		return service.consultarPorId(id).map(
					entity -> {
						try {
					/* Meta encontrada
					 * */
							Meta meta = this.converter(dto);
							meta.setId(entity.getId());
							service.atualizar(meta);
							return ResponseEntity.ok(meta);
						} catch (SadException sadException) {
					/* Meta encontrada, porém erro na manipulação
					 * */
							return ResponseEntity.badRequest().body(sadException.getMessage());
						}
					}
				).orElseGet(
					/* Meta não encontrada
					 * */
						() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar uma "
								+ "meta com o ID informado.")
						);
	}
	
		/* http://localhost:8080/api/metas/inativar/{id}
		 * */
	@PutMapping("/inativar/{id}")
	public ResponseEntity inativar( @PathVariable("id") Long id, @RequestBody MetaDTO dto) {
		return service.consultarPorId(id).map(
					entity -> {
						try {
					/* Meta encontrada
					 * */
							Meta meta = this.converter(dto);
							meta.setId(entity.getId());
							service.inativar(meta);
							return ResponseEntity.ok(meta);
						} catch (SadException sadException) {
					/* Meta encontrada, porém erro na manipulação
					 * */
							return ResponseEntity.badRequest().body(sadException.getMessage());
						}
					}
				).orElseGet(
					/* Meta não encontrada
					 * */
						() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar uma "
								+ "meta com o ID informado, logo a inativação não pode ser realizada.")
						);
	}
	
		/* http://localhost:8080/api/metas/buscar
		 * */
	@GetMapping("/buscar")
	public ResponseEntity<List<MetaDTO>> buscar() {
		
		List<MetaDTO> metas = service.buscar();
		return ResponseEntity.ok(metas);
	}
}
