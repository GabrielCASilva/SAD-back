package com.trabalho.sad.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa {

	/*
	 * Atributos
	 ***************************************************************************************************/
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "dataCriacao", nullable = false)
	private LocalDate dataCriacao;

	@Column(name = "dataPrevistaConclusao", nullable = false)
	private LocalDate dataPrevistaConclusao;

	@Column(name = "dataInicio")
	private LocalDate dataInicio;

	@Column(name = "dataConclusao")
	private LocalDate dataConclusao;

	@Column(name = "taxaProgresso", nullable = false)
	private double taxaProgresso;

	@Column(name = "situacao", nullable = false)
	private String situacao;

	/*
	 * Atributos - Mapping
	 ***************************************************************************************************/
	@ManyToOne(optional = true)
	@JoinColumn(name = "meta_id")
	private Meta meta;

	@ManyToOne(optional = true)
	@JoinColumn(name = "funcionarioAlocado_id")
	private Funcionario funcionarioAlocado;

	@ManyToOne(optional = true)
	@JoinColumn(name = "funcionarioResponsavel_id")
	private Funcionario funcionarioResponsavel;

	/*
	 * Construtor
	 ***************************************************************************************************/
	public Tarefa(Long id, String nome, String descricao, LocalDate dataCriacao, LocalDate dataPrevistaConclusao,
			LocalDate dataInicio, LocalDate dataConclusao, double taxaProgresso, String situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataInicio = dataInicio;
		this.dataConclusao = dataConclusao;
		this.taxaProgresso = taxaProgresso;
		this.situacao = situacao;
	}

	public Tarefa() {
		super();
	}

	/*
	 * Getters e Setters
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataPrevistaConclusao() {
		return dataPrevistaConclusao;
	}

	public void setDataPrevistaConclusao(LocalDate dataPrevistaConclusao) {
		this.dataPrevistaConclusao = dataPrevistaConclusao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public double getTaxaProgresso() {
		return taxaProgresso;
	}

	public void setTaxaProgresso(double taxaProgresso) {
		this.taxaProgresso = taxaProgresso;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Meta getMeta() {
		return meta;
	}

	public Funcionario getFuncionarioAlocado() {
		return funcionarioAlocado;
	}

	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

}
