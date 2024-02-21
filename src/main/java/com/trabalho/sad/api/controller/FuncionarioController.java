package com.trabalho.sad.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.sad.api.dto.FuncionarioDTO;
import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService service;
	
	//método auxiliar para converter ObjetoDTO em uma Entidade
	private Funcionario converter(FuncionarioDTO dto) {
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(dto.getNome());
		funcionario.setDataNascimento(dto.getDataNascimento());
		funcionario.setSexo(dto.getSexo());
		funcionario.setCpf(dto.getCpf());

		return funcionario;
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> buscar(){
		
		List<Funcionario> list = service.buscar();
		
		return ResponseEntity.ok().body(list);
	}	
}
