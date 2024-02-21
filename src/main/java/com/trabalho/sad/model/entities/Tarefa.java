package com.trabalho.sad.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa {
	
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
	
	@Column(name = "datainicio")
	private LocalDate dataInicio;
	
	@Column(name = "dataConclusao")
	private LocalDate dataConclusao;
	
	@Column(name = "taxaProgresso", nullable = false)
	private double taxaProgresso;
	
	@Column(name = "idFuncionarioAlocado", nullable = false)
	private Long idFuncionarioAlocado;
	
	@Column(name = "idMeta", nullable = false)
	private Long idMeta;

	@Column(name = "idSituacaoSetor", nullable = false)
	private Long idSituacaoSetor;
	
	@Column(name = "idFuncionarioResponsavel", nullable = false)
	private Long idFuncionarioResponsavel;
	
	/* Construtor 
	 ***************************************************************************************************/
	public Tarefa(Long id, String nome, String descricao, LocalDate dataCriacao, LocalDate dataPrevistaConclusao,
			LocalDate dataInicio, LocalDate dataConclusao, double taxaProgresso, Long idFuncionarioAlocado, Long idMeta,
			Long idSituacaoSetor, Long idFuncionarioResponsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataInicio = dataInicio;
		this.dataConclusao = dataConclusao;
		this.taxaProgresso = taxaProgresso;
		this.idFuncionarioAlocado = idFuncionarioAlocado;
		this.idMeta = idMeta;
		this.idSituacaoSetor = idSituacaoSetor;
		this.idFuncionarioResponsavel = idFuncionarioResponsavel;
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


	public Long getIdFuncionarioAlocado() {
		return idFuncionarioAlocado;
	}


	public void setIdFuncionarioAlocado(Long idFuncionarioAlocado) {
		this.idFuncionarioAlocado = idFuncionarioAlocado;
	}


	public Long getIdMeta() {
		return idMeta;
	}


	public void setIdMeta(Long idMeta) {
		this.idMeta = idMeta;
	}


	public Long getIdSituacaoSetor() {
		return idSituacaoSetor;
	}


	public void setIdSituacaoSetor(Long idSituacaoSetor) {
		this.idSituacaoSetor = idSituacaoSetor;
	}


	public Long getIdFuncionarioResponsavel() {
		return idFuncionarioResponsavel;
	}


	public void setIdFuncionarioResponsavel(Long idFuncionarioResponsavel) {
		this.idFuncionarioResponsavel = idFuncionarioResponsavel;
	}

}
