package com.trabalho.sad.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.trabalho.sad.api.dto.CargoDTO;
import com.trabalho.sad.exceptions.SadException;
import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.model.repository.CargoRepository;
import com.trabalho.sad.service.CargoService;

	/* http://localhost:8080/api/cargos
	 * */
@RestController
@RequestMapping("/api/cargos")
@CrossOrigin(origins = "*")
public class CargoController {
	
	CargoService service;
	
	/* Construtor 
	 ***************************************************************************************************/
	public CargoController(CargoService service) {
		this.service = service;
	}

	
	/* Métodos 
	 ***************************************************************************************************/
	
		/* Conversor de objetos DTO em Entidades
		 * */
	private Cargo converter(CargoDTO dto) {
		
		Cargo cargo = new Cargo();
		
		cargo.setNome(dto.getNome());
		cargo.setTipoAvaliacao(dto.getTipoAvaliacao());
		cargo.setPermitidoManterMeta(dto.isPermitidoManterMeta());
		cargo.setPermitidoAvaliacaoServidor(dto.isPermitidoAvaliacaoServidor());
		cargo.setPermitidoAvaliacaoSupervisor(dto.isPermitidoAvaliacaoSupervisor());
		cargo.setPermitidoManterFuncionario(dto.isPermitidoManterFuncionario());
		cargo.setPermitidoManterSetor(dto.isPermitidoManterSetor());
		cargo.setPermitidoManterTarefa(dto.isPermitidoManterTarefa());
		cargo.setPermitidoAtribuirTarefa(dto.isPermitidoAtribuirTarefa());
		cargo.setPermitidoProgredirTarefa(dto.isPermitidoProgredirTarefa());
		
		if(dto.getId() != null){
			cargo.setId(dto.getId());
		}
		
		return cargo;
	}
	
		/* http://localhost:8080/api/cargos/cadastrar
		 * */
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar( @RequestBody CargoDTO dto) {
		try {
			Cargo entidadeCargo = this.converter(dto);
			entidadeCargo = this.service.cadastrar(entidadeCargo);
			return ResponseEntity.ok(entidadeCargo);
		} catch (SadException sadException) {
			return ResponseEntity.badRequest().body(sadException.getMessage());
		}
	}
	
		/* http://localhost:8080/api/cargos/atualizar/{id}
		 * */
	//TODO Proteger?
	//	1) Não pode mudar as permissões do administrador!		
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> atualizar( @PathVariable("id") Long id, @RequestBody CargoDTO dto) {
		return service.consultarPorId(id).map(
					entity -> {
						try {
					/* Cargo encontrado
					 * */
							Cargo cargo = this.converter(dto);
							cargo.setId(entity.getId());
							service.atualizar(cargo);
							return ResponseEntity.ok(cargo);
						} catch (SadException sadException) {
					/* Cargo encontrado, porém erro na manipulação
					 * */
							return ResponseEntity.badRequest().body(sadException.getMessage());
						}
					}
				).orElseGet(
					/* Cargo não encontrado
					 * */
						() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar um "
								+ "cargo com o ID informado.")
						);
	}
	
		/* http://localhost:8080/api/cargos/deletar/{id}
		 * */
	//TODO Proteger?
	//	1) Impedir de deletar se houver pelo menos 1 funcionário com esse cargo
	//	2) Não pode deletar o administrador!
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<?> deletar( @PathVariable("id") Long id ) {
		return service.consultarPorId(id).map(
				entity -> {
				/* Cargo encontrado
				 * */
					service.deletar(entity);
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
			).orElseGet(
				/* Cargo não encontrado
				 * */
					() -> ResponseEntity.badRequest().body("Erro: Não foi possível encontrar um "
							+ "cargo com o ID informado, logo a exclusão não pode ser efetuada.")
					);
	}
	
	
		/* http://localhost:8080/api/cargos/buscar
		 * */
	// @GetMapping("/buscar")
	// public ResponseEntity<List<Cargo>> buscar(
	// 		@RequestParam(value = "id", required = false) Long id,
	// 		@RequestParam(value = "nome", required = false) String nome,
	// 		@RequestParam(value = "tipoAvaliacao", required = false) String tipoAvaliacao
	// 		) {
	// 	Cargo cargoFiltro = new Cargo();
	// 	cargoFiltro.setId(id);
	// 	cargoFiltro.setNome(nome);
	// 	cargoFiltro.setTipoAvaliacao(tipoAvaliacao);
		
	// 	List<Cargo> cargos = service.buscar(cargoFiltro);
	// 	return ResponseEntity.ok(cargos);
	// }

	@GetMapping("/buscar")
	public ResponseEntity<Page<CargoDTO>> findAll(Pageable pageable) {
		Page<CargoDTO> dto = service.buscar(pageable);
		return ResponseEntity.ok(dto);
	}

	// TESTE COM REQUESTPARAM
	@GetMapping("/registro")
	public ResponseEntity<List<CargoDTO>> buscar(@RequestParam(required = false) Long id) {

		List<CargoDTO> cargos = service.findAll(id);
		return ResponseEntity.ok(cargos);
	}
}