package com.trabalho.sad.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.trabalho.sad.model.entities.enums.SituacaoServico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", nullable = false)
	private SituacaoServico situacao;
	
	@ManyToOne
	@JoinColumn(name = "supervisor_id")
	private Funcionario supervisor;
	
	@ManyToOne
	@JoinColumn(name = "servidor_id")
	private Funcionario servidor;
	
	@ManyToOne
	@JoinColumn(name = "meta_id")
	private Meta meta;
	
	public Tarefa() {		
	}
	
	
	public Tarefa(String nome, String descricao, LocalDate dataCriacao, LocalDate dataPrevistaConclusao,
			LocalDate dataInicio, LocalDate dataConclusao, double taxaProgresso, SituacaoServico situacao, Funcionario supervisor, Funcionario servidor,
			Meta meta) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataInicio = dataInicio;
		this.dataConclusao = dataConclusao;
		this.taxaProgresso = taxaProgresso;
		this.situacao = situacao;
		this.supervisor = supervisor;
		this.servidor = servidor;
		this.meta = meta;
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

	public double getTaxaProgresso() {
		return taxaProgresso;
	}

	public void setTaxaProgresso(double taxaProgresso) {
		this.taxaProgresso = taxaProgresso;
	}
	
	public SituacaoServico getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoServico situacao) {
		if (situacao != null) {
			this.situacao = situacao;
		}
	}


	public Funcionario getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Funcionario supervisor) {
		this.supervisor = supervisor;
	}

	public Funcionario getServidor() {
		return servidor;
	}

	public void setServidor(Funcionario servidor) {
		this.servidor = servidor;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
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
}
