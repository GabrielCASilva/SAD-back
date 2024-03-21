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

import com.trabalho.sad.api.dto.SetorDTO;
import com.trabalho.sad.exceptions.RegraNegocioException;
import com.trabalho.sad.model.entities.Setor;
import com.trabalho.sad.service.SetorService;

@RestController
@RequestMapping(value = "/setores")
@CrossOrigin(origins = "*")
public class SetorController {
	
	@Autowired
	SetorService setorService;
	
	public Setor converter(SetorDTO dto) {		
		Setor setor = new Setor();	
		setor.setNome(dto.getNome());
		setor.setLocalizacao(dto.getLocalizacao());
		setor.setSupervisor(dto.getSupervisor());
		return setor;
	}
		
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody SetorDTO dto) {
		try {
			Setor obj = converter(dto);
			obj = setorService.cadastrar(obj);
			return ResponseEntity.ok(obj);
		}
		catch(RegraNegocioException regraNegocioException){
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}		
	}
	
	@PutMapping(value = "/{id}")		
	public ResponseEntity<Setor> atualizar(@PathVariable Long id, @RequestBody SetorDTO dto){
		Setor obj = converter(dto);
		obj = setorService.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Setor>> buscar(){		
		List<Setor> list = setorService.buscar();	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Setor> consultarPorId(@PathVariable Long id){
		Setor obj = setorService.consultarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
