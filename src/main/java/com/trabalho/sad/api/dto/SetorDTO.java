package com.trabalho.sad.api.dto;

import com.trabalho.sad.model.entities.Funcionario;

public class SetorDTO {
	
	private Long id;
	private String nome;
	private String localizacao;
	private Funcionario supervisor;
	
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
	private Long ramal;

	public Funcionario getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Funcionario supervisor) {
		this.supervisor = supervisor;
	}	
}
