package com.trabalho.sad.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.service.CargoService;

@RestController
@RequestMapping(value = "/cargos")
public class CargoController {

	@Autowired
	CargoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Cargo>> buscar(){
		
		List<Cargo> list = service.buscar();
		
		return ResponseEntity.ok().body(list);
	}
}
