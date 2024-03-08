package com.trabalho.sad.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trabalho.sad.model.entities.status.SituacaoServico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "meta")
public class Meta {
	
	/* Atributos 
	 ***************************************************************************************************/
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
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", nullable=false)
	private SituacaoServico situacao;
	
	
	/* Atributos - Mapping
	 ***************************************************************************************************/
	@ManyToOne(optional = true)
	@JoinColumn(name="responsavel_id")
	private Funcionario responsavel;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="setor_id")
	private Setor setor;
	
	@OneToMany(mappedBy = "meta")
	private List<Tarefa> tarefas = new ArrayList<>();

	/* Construtor 
	 ***************************************************************************************************/
	public Meta(Long id, String nome, String descricao, LocalDate dataCriacao, LocalDate dataPrevistaConclusao,
			LocalDate dataConclusao, SituacaoServico situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataConclusao = dataConclusao;
		this.situacao = situacao;
	}
	
	public Meta() {
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

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public Setor getSetor() {
		return setor;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

}
