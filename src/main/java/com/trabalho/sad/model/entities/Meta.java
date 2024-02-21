package com.trabalho.sad.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meta")
public class Meta {
	
	@Id
	@Column(name = "id", nullable = false)
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
	
	@Column(name = "dataConclusao")
	private LocalDate dataConclusao;
	
	@Column(name = "idFuncionario", nullable = false)
	private Long idFuncionario;
	
	@Column(name = "idSetor", nullable = false)
	private Long idSetor;
	
	@Column(name = "idSituacaoServico", nullable = false)
	private Long idSituacaoServico;

	/* Construtor 
	 ***************************************************************************************************/
	public Meta(Long id, String nome, String descricao, LocalDate dataCriacao, LocalDate dataPrevistaConclusao,
			LocalDate dataConclusao, Long idFuncionario, Long idSetor, Long idSituacaoServico) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataConclusao = dataConclusao;
		this.idFuncionario = idFuncionario;
		this.idSetor = idSetor;
		this.idSituacaoServico = idSituacaoServico;
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


	public Long getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}


	public Long getIdSetor() {
		return idSetor;
	}


	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}


	public Long getIdSituacaoServico() {
		return idSituacaoServico;
	}


	public void setIdSituacaoServico(Long idSituacaoServico) {
		this.idSituacaoServico = idSituacaoServico;
	}

}
