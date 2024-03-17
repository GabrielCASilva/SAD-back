package com.trabalho.sad.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.sad.model.entities.enums.SituacaoMeta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "meta")
public class Meta implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	
	@Column(name = "situacaoMeta")
	private String situacaoMeta;
	
	@ManyToOne
	@JoinColumn(name = "diretor_id")
	private Funcionario diretor;	
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "meta")
	private List<Tarefa> tarefas = new ArrayList<>();
	
	public Meta() {
	}		

	public Meta(String nome, String descricao, LocalDate dataCriacao, LocalDate dataPrevistaConclusao,
			LocalDate dataConclusao, SituacaoMeta situacaoMeta, Funcionario diretor, Setor setor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataConclusao = dataConclusao;
		setSituacaoMeta(situacaoMeta);
		this.diretor = diretor;
		this.setor = setor;
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

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public SituacaoMeta getSituacaoMeta() {
		return SituacaoMeta.valueOf(situacaoMeta);
	}

	public void setSituacaoMeta(SituacaoMeta situacaoMeta) {
		if (situacaoMeta != null) {
			this.situacaoMeta = situacaoMeta.getCode();
		}
	}

	public Funcionario getDiretor() {
		return diretor;
	}

	public void setDiretor(Funcionario diretor) {
		this.diretor = diretor;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
}
