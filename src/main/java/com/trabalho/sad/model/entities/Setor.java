package com.trabalho.sad.model.entities;

import java.util.ArrayList;
import java.util.List;

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
public class Setor {
	
	/* Atributos 
	 ***************************************************************************************************/
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
	
	/* Atributos - Mapping
	 ***************************************************************************************************/
	@OneToMany(mappedBy = "setorParticipa")
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="supervisor_id", referencedColumnName = "id")
	private Funcionario supervisor;
	
	@OneToMany(mappedBy = "setor")
	private List<Meta> metas  = new ArrayList<>();
	

	/* Construtor 
	 ***************************************************************************************************/
	public Setor(Long id, String nome, String localizacao, Long ramal) {
		super();
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
		this.ramal = ramal;
	}
	
	public Setor() {
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Funcionario getSupervisor() {
		return supervisor;
	}

	public List<Meta> getMetas() {
		return metas;
	}
	
}
