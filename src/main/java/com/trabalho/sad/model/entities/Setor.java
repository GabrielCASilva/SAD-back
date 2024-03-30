package com.trabalho.sad.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "setor")
public class Setor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "localizacao", nullable = false)
	private String localizacao;
	
	@Column(name = "ramal", nullable = false)
	private Long ramal;
	
	@OneToOne
	@JsonIgnoreProperties("setor")
	@JoinColumn(name = "supervisor_id")
	private Funcionario supervisor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "setor")
	private List<Funcionario> funcionarios = new ArrayList<>();
	

	public Setor() {
	}
	
	public Setor(String nome, String localizacao, Long ramal, Funcionario supervisor) {
		super();
		this.nome = nome;
		this.localizacao = localizacao;
		this.ramal = ramal;
		this.supervisor = supervisor;
	}

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
	
	public Funcionario getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Funcionario supervisor) {
		this.supervisor = supervisor;
	}
}
