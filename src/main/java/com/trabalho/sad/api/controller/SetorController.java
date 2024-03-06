package com.trabalho.sad.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.sad.api.dto.FuncionarioDTO;
import com.trabalho.sad.api.dto.SetorDTO;
import com.trabalho.sad.exceptions.SadException;
import com.trabalho.sad.model.entities.Setor;
import com.trabalho.sad.service.SetorService;

/* http://localhost:8080/api/setores
 * */
@RestController
@RequestMapping("/api/setores")
@CrossOrigin(origins = "*")
public class SetorController {
	
	SetorService service;
	
	/* Construtor 
	 ***************************************************************************************************/
	public SetorController(SetorService service) {
		this.service = service;
	}
	
		
	/* Métodos 
	 ***************************************************************************************************/
	
		/* Conversor de objetos DTO em Entidades
		 * */
	private Setor converter(SetorDTO dto) {
			
		Setor setor = new Setor();
		
		setor.setNome(dto.getNome());
		setor.setLocalizacao(dto.getLocalizacao());
		setor.setRamal(dto.getRamal());
		
		if(dto.getId() != null){
			setor.setId(dto.getId());
		}
		
		return setor;
	}
	
		/* http://localhost:8080/api/setores/cadastrar
		 * */
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrar( @RequestBody SetorDTO dto) {
		try {
			Setor entidadeSetor = this.converter(dto);
			entidadeSetor = this.service.cadastrar(entidadeSetor);
			return ResponseEntity.ok(entidadeSetor);
		} catch (SadException sadException) {
			return ResponseEntity.badRequest().body(sadException.getMessage());
		}
	}
	
	/* http://localhost:8080/api/setores/atualizar/{id}
	 * */
	@PutMapping("/atualizar/{id}")
	public ResponseEntity atualizar( @PathVariable("id") Long id, @RequestBody SetorDTO dto) {
		return service.consultarPorId(id).map(
					entity -> {
						try {
					/* Setor encontrado
					 * */
							Setor setor = this.converter(dto);
							setor.setId(entity.getId());
							service.atualizar(setor);
							return ResponseEntity.ok(setor);
						} catch (SadException sadException) {
					/* Setor encontrado, porém erro na manipulação
					 * */
							return ResponseEntity.badRequest().body(sadException.getMessage());
						}
					}
				).orElseGet(
					/* Setor não encontrado
					 * */
						() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar um "
								+ "setor com o ID informado.")
						);
	}
	
		/* http://localhost:8080/api/setores/deletar/{id}
		 * */
	//TODO Proteger
	//	1) Não pode deletar o setor se houver pelo menos 1 funcionário alocado ao mesmo
	@DeleteMapping("deletar/{id}")
	public ResponseEntity deletar( @PathVariable("id") Long id ) {
		return service.consultarPorId(id).map(
				entity -> {
				/* Setor encontrado
				 * */
					service.deletar(entity);
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
			).orElseGet(
				/* Setor não encontrado
				 * */
					() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar um "
							+ "setor com o ID informado, logo a exclusão não pode ser efetuada.")
					);
	}

		/* http://localhost:8080/api/setores/buscar
		 * */
	@GetMapping("/buscar")
	public ResponseEntity buscar(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "nome", required = false) String nome
			) {
		Setor setorFiltro = new Setor();
		setorFiltro.setId(id);
		setorFiltro.setNome(nome);
		
		List<Setor> setores = service.buscar(setorFiltro);
		return ResponseEntity.ok(setores);
	}

		@GetMapping("/buscar2")
	public ResponseEntity<List<SetorDTO>> findAll() {

		List<SetorDTO> dto = service.findAll();
		return ResponseEntity.ok(dto);
	}
	
}
