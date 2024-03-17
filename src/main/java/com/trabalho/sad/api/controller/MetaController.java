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

import com.trabalho.sad.api.dto.MetaDTO;
import com.trabalho.sad.exceptions.RegraNegocioException;
import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.service.MetaService;

@RestController
@RequestMapping(value = "/metas")
@CrossOrigin(origins = "*")
public class MetaController {

	@Autowired
	MetaService metaService;

	private Meta converter(MetaDTO dto) {
		Meta meta = new Meta();
		meta.setNome(dto.getNome());
		meta.setDescricao(dto.getDescricao());
		meta.setDataCriacao(dto.getDataCriacao());
		meta.setDataPrevistaConclusao(dto.getDataPrevistaConclusao());
		meta.setDataConclusao(dto.getDataConclusao());
		return meta;
	}

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody MetaDTO dto) {
		try {
			Meta obj = converter(dto);
			obj = metaService.cadastrar(obj);
			return ResponseEntity.ok(obj);
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Meta> atualizar(@PathVariable Long id, @RequestBody MetaDTO dto) {
		Meta obj = converter(dto);
		obj = metaService.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Meta>> buscar() {
		List<Meta> list = metaService.buscar();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Meta> consultarPorId(@PathVariable Long id) {
		Meta obj = metaService.consultarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
