package com.trabalho.sad.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.sad.model.entities.Setor;
import com.trabalho.sad.service.SetorService;

@RestController
@RequestMapping(value = "/setores")
public class SetorController {
	
	@Autowired
	SetorService service;
	
	@GetMapping
	public ResponseEntity<List<Setor>> buscar(){
		
		List<Setor> list = service.buscar();
		
		return ResponseEntity.ok().body(list);
	}
}
