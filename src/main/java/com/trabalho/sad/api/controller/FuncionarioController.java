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

import com.trabalho.sad.api.dto.FuncionarioDTO;
import com.trabalho.sad.exceptions.SadException;
import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.service.FuncionarioService;


	/* http://localhost:8080/api/funcionarios
	 * */
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
	
	FuncionarioService service;
	
	/* Construtor 
	 ***************************************************************************************************/
	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}
	
	
	/* Métodos 
	 ***************************************************************************************************/
	
		/* Conversor de objetos DTO em Entidades
		 * */
	private Funcionario converter(FuncionarioDTO dto) {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(dto.getNome());
		funcionario.setDataNascimento(dto.getDataNascimento());
		funcionario.setSexo(dto.getSexo());
		funcionario.setCpf(dto.getCpf());
		funcionario.setCep(dto.getCep());
		funcionario.setEndereco(dto.getEndereco());
		funcionario.setTelefone(dto.getTelefone());
		funcionario.setEmail(dto.getEmail());
		funcionario.setDataCadastro(dto.getDataCadastro());
		funcionario.setLogin(dto.getLogin());
		funcionario.setSenhaHash(dto.getSenhaHash());
		funcionario.setSituacao(dto.getSituacao());
		
		if(dto.getId() != null) {
			funcionario.setId(dto.getId());
		}
		
		return funcionario;
	}
	
		/* http://localhost:8080/api/funcionarios/cadastrar
		 * */
	//TODO Proteger
	//	1) Login tem q ser único
	//	2) Data de nascimento não pode ser depois da data de cadastro
	//	3) CPF tem q ser único
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrar( @RequestBody FuncionarioDTO dto) {
		try {
			Funcionario entidadeFuncionario = this.converter(dto);
			entidadeFuncionario = this.service.cadastrar(entidadeFuncionario);
			return ResponseEntity.ok(entidadeFuncionario);
		} catch (SadException sadException) {
			return ResponseEntity.badRequest().body(sadException.getMessage());
		}
	}
	
		/* http://localhost:8080/api/funcionarios/atualizar/{id}
		 * */
	//TODO Proteger
	//	1) Não pode mudar data de cadastro
	//	2) Data de nascimento não pode ser depois da data de cadastro
	@PutMapping("/atualizar/{id}")
	public ResponseEntity atualizar( @PathVariable("id") Long id, @RequestBody FuncionarioDTO dto) {
		return service.consultarPorId(id).map(
					entity -> {
						try {
					/* Funcionario encontrado
					 * */
							Funcionario funcionario = this.converter(dto);
							funcionario.setId(entity.getId());
							service.atualizar(funcionario);
							return ResponseEntity.ok(funcionario);
						} catch (SadException sadException) {
					/* Funcionario encontrado, porém erro na manipulação
					 * */
							return ResponseEntity.badRequest().body(sadException.getMessage());
						}
					}
				).orElseGet(
					/* Funcionario não encontrado
					 * */
						() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar um "
								+ "funcionário com o ID informado.")
						);
	}
	
	
		/* http://localhost:8080/api/funcionarios/inativar/{id}
		 * */
	@PutMapping("/inativar/{id}")
	public ResponseEntity inativar( @PathVariable("id") Long id, @RequestBody FuncionarioDTO dto) {
		return service.consultarPorId(id).map(
					entity -> {
						try {
					/* Funcionario encontrado
					 * */
							Funcionario funcionario = this.converter(dto);
							funcionario.setId(entity.getId());
							service.inativar(funcionario);
							return ResponseEntity.ok(funcionario);
						} catch (SadException sadException) {
					/* Funcionario encontrado, porém erro na manipulação
					 * */
							return ResponseEntity.badRequest().body(sadException.getMessage());
						}
					}
				).orElseGet(
					/* Funcionario não encontrado
					 * */
						() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar um "
								+ "funcionário com o ID informado, logo a inativação não pode ser realizada.")
						);
	}
	
		/* http://localhost:8080/api/funcionarios/buscar
		 * */
	@GetMapping("/buscar")
	public ResponseEntity buscar(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "cpf", required = false) Long cpf,
			@RequestParam(value = "telefone", required = false) Long telefone,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "situacao", required = false) String situacao
			) {
		Funcionario funcionarioFiltro = new Funcionario();
		funcionarioFiltro.setId(id);
		funcionarioFiltro.setNome(nome);
		funcionarioFiltro.setCpf(cpf);
		funcionarioFiltro.setTelefone(telefone);
		funcionarioFiltro.setEmail(email);
		funcionarioFiltro.setLogin(login);
		funcionarioFiltro.setSituacao(situacao);
		
		List<Funcionario> funcionarios = service.buscar(funcionarioFiltro);
		return ResponseEntity.ok(funcionarios);
	}
}
