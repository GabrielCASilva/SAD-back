package com.trabalho.sad.api.dto;

public class SetorDTO {
	
	/* Atributos 
	 ***************************************************************************************************/
	private Long id;
	private String nome;
	private String localizacao;
	private Long ramal;
	
	
	/* Construtor 
	 ***************************************************************************************************/
	public SetorDTO() {
		super();
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

}
