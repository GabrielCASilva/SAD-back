package com.trabalho.sad.model.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "setor")
public class Setor {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codSetor", nullable = false)
	private String codSetor;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "localizacao", nullable = false)
	private String localizacao;
	
	@Column(name = "ramal", nullable = false)
	private Long ramal;
	
	@JsonIgnore
	@OneToMany(mappedBy = "setor")
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "chefe_id", unique=true)
	private Funcionario chefe;
	
	

	/* Construtor 
	 ***************************************************************************************************/
	public Setor() {
	}
	
	public Setor(String codSetor, String nome, String localizacao, Long ramal) {
		super();
		this.id = null;
		this.codSetor = codSetor;
		this.nome = nome;
		this.localizacao = localizacao;
		this.ramal = ramal;
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

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}
}
