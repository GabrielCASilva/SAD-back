package com.trabalho.sad.api.dto;

import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.Setor;

public class SetorDTO {
	
	/* Atributos 
	 ***************************************************************************************************/
	private Long id;
	private String nome;
	private String localizacao;
	private Long ramal;
	private FuncionarioDTO supervisor = new FuncionarioDTO();
	
	
	/* Construtor 
	 ***************************************************************************************************/
	public SetorDTO() {
		super();
	}
	
	
	public SetorDTO(Long id, String nome, String localizacao, Long ramal, FuncionarioDTO supervisor) {
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
		this.ramal = ramal;
		this.supervisor = supervisor;
	}

	public SetorDTO(Setor entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.localizacao = entity.getLocalizacao();
		this.ramal = entity.getRamal();
		this.supervisor = new FuncionarioDTO(entity.getSupervisor());;
	}

	/* Getters e Setters 
	 ***************************************************************************************************/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Long getRamal() {
		return ramal;
	}
	public void setRamal(Long ramal) {
		this.ramal = ramal;
	}

	public FuncionarioDTO getSupervisor() {
		return supervisor;
	}


	public void setSupervisor(FuncionarioDTO supervisor) {
		this.supervisor = supervisor;
	}

}
