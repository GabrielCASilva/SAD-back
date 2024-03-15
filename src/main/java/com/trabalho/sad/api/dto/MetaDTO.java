package com.trabalho.sad.api.dto;

import java.time.LocalDate;

public class MetaDTO {

	private Long id;	
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	private LocalDate dataPrevistaConclusao;
	private LocalDate dataConclusao;
	private Integer situacaoMeta;
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
	public LocalDate getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public Integer getSituacaoMeta() {
		return situacaoMeta;
	}
	public void setSituacaoMeta(Integer situacaoMeta) {
		this.situacaoMeta = situacaoMeta;
	}	
}
