package com.trabalho.sad.api.dto;

import java.time.LocalDate;

import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.model.entities.status.SituacaoServico;

public class MetaDTO {
	
	/* Atributos 
	 ***************************************************************************************************/
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	private LocalDate dataPrevistaConclusao;
	private LocalDate dataConclusao;
	private SituacaoServico situacao;
	private FuncionarioDTO responsavel;
	private SetorDTO setor;
	



	/* Construtor 
	 ***************************************************************************************************/
	public MetaDTO() {
		super();
	}
	
	
	public MetaDTO(Long id, String nome, String descricao, LocalDate dataCriacao, LocalDate dataPrevistaConclusao,
			LocalDate dataConclusao, SituacaoServico situacao, FuncionarioDTO responsavel, SetorDTO setor ) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataConclusao = dataConclusao;
		this.situacao = situacao;
		this.responsavel = responsavel;
		this.setor = setor;
	}

	public MetaDTO(Meta entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.dataCriacao = entity.getDataCriacao();
		this.dataPrevistaConclusao = entity.getDataPrevistaConclusao();
		this.dataConclusao = entity.getDataConclusao();
		this.situacao = entity.getSituacao();
		this.responsavel = new FuncionarioDTO(entity.getResponsavel());
		this.setor = new SetorDTO(entity.getSetor());
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
	public LocalDate getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public SituacaoServico getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoServico situacao) {
		this.situacao = situacao;
	}

		
	public FuncionarioDTO getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(FuncionarioDTO responsavel) {
		this.responsavel = responsavel;
	}


	public SetorDTO getSetor() {
		return setor;
	}


	public void setSetor(SetorDTO setor) {
		this.setor = setor;
	}
	
}
