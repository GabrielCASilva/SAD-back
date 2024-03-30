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

import com.trabalho.sad.api.dto.FuncionarioDTO;
import com.trabalho.sad.exceptions.RegraNegocioException;
import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.service.FuncionarioService;
import com.trabalho.sad.service.TarefaService;

@RestController
@RequestMapping(value = "/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	@Autowired
	TarefaService tarefaService;

	private Funcionario converter(FuncionarioDTO dto) {		
		Funcionario funcionario = new Funcionario();	
		funcionario.setNome(dto.getNome());
		funcionario.setDataNascimento(dto.getDataNascimento());
		funcionario.setSexo(dto.getSexo());
		funcionario.setCpf(dto.getCpf());
		funcionario.setCep(dto.getCep());
		funcionario.setEndereco(dto.getEndereco());
		funcionario.setTelefone(dto.getTelefone());
		funcionario.setFoto(dto.getFoto());
		funcionario.setEmail(dto.getEmail());
		funcionario.setDataCadastro(dto.getDataCadastro());
		funcionario.setLogin(dto.getLogin());
		funcionario.setSenhaHash(dto.getSenhaHash());
		funcionario.setSituacao(dto.getSituacao());
		return funcionario;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody FuncionarioDTO dto) {
		try {
			Funcionario obj = converter(dto);
			obj = funcionarioService.cadastrar(obj);
			return ResponseEntity.ok(obj);
		}
		catch(RegraNegocioException regraNegocioException){
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}		
	}
	
	@PutMapping(value = "/{id}")		
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody FuncionarioDTO dto){
		Funcionario obj = converter(dto);
		obj = funcionarioService.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> buscar(){	
		List<Funcionario> list = funcionarioService.buscar();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> consultarPorId(@PathVariable Long id){
		Funcionario obj = funcionarioService.consultarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
