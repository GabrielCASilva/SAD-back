package com.trabalho.sad.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.sad.api.dto.CargoDTO;
import com.trabalho.sad.exceptions.RegraNegocioException;
import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.service.CargoService;

@RestController
@RequestMapping(value = "/cargos")
public class CargoController {

	@Autowired
	CargoService cargoService;
	
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
		return cargo;
	}
	
	@PostMapping("/salvar{id}")
	public ResponseEntity<?> cadastrar(@RequestBody CargoDTO dto) {
		try {
			Cargo obj = converter(dto);
			obj = cargoService.cadastrar(obj);
			return ResponseEntity.ok(obj);
		}
		catch(RegraNegocioException regraNegocioException){
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}		
	}
	
	@PutMapping(value = "/{id}")		
	public ResponseEntity<Cargo> atualizar(@PathVariable Long id, @RequestBody CargoDTO dto){
		Cargo obj = converter(dto);
		obj = cargoService.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
		
	@GetMapping
	public ResponseEntity<List<Cargo>> buscar(){		
		List<Cargo> list = cargoService.buscar();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cargo> consultarPorId(@PathVariable Long id){
		Cargo obj = cargoService.consultarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
