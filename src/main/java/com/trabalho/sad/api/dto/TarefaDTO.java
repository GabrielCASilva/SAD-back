package com.trabalho.sad.api.dto;

import java.time.LocalDate;

import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.model.entities.enums.SituacaoServico;

public class TarefaDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	private LocalDate dataPrevistaConclusao;
	private LocalDate dataInicio;
	private LocalDate dataConclusao;
	private double taxaProgresso;
	private SituacaoServico situacao;
	private Funcionario supervisor;
	private Funcionario servidor;
	private Meta meta;
	
	
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
	public SituacaoServico getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoServico situacao) {
		this.situacao = situacao;
	}	
}
