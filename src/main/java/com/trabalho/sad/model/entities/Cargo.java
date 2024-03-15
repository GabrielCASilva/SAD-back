package com.trabalho.sad.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "tipoAvaliacao", nullable = false)
	private String tipoAvaliacao;
	
	@Column(name = "permitidoManterMeta", nullable = false)
	private boolean permitidoManterMeta;
	
	@Column(name = "permitidoAvaliacaoServidor", nullable = false)
	private boolean permitidoAvaliacaoServidor;
	
	@Column(name = "permitidoAvaliacaoSupervisor", nullable = false)
	private boolean permitidoAvaliacaoSupervisor;
	
	@Column(name = "permitidoManterFuncionario", nullable = false)
	private boolean permitidoManterFuncionario;
	
	@Column(name = "permitidoManterSetor", nullable = false)
	private boolean permitidoManterSetor;
	
	@Column(name = "permitidoManterTarefa", nullable = false)
	private boolean permitidoManterTarefa;
	
	@Column(name = "permitidoAtribuirTarefa", nullable = false)
	private boolean permitidoAtribuirTarefa;
	
	@Column(name = "permitidoProgredirTarefa", nullable = false)
	private boolean permitidoProgredirTarefa;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios = new ArrayList<>();	

	
	public Cargo() {
	}
	
	public Cargo(String nome, String tipoAvaliacao, boolean permitidoManterMeta,
			boolean permitidoAvaliacaoServidor, boolean permitidoAvaliacaoSupervisor,
			boolean permitidoManterFuncionario, boolean permitidoManterSetor, boolean permitidoManterTarefa,
			boolean permitidoAtribuirTarefa, boolean permitidoProgredirTarefa) {
		super();
		this.nome = nome;
		this.tipoAvaliacao = tipoAvaliacao;
		this.permitidoManterMeta = permitidoManterMeta;
		this.permitidoAvaliacaoServidor = permitidoAvaliacaoServidor;
		this.permitidoAvaliacaoSupervisor = permitidoAvaliacaoSupervisor;
		this.permitidoManterFuncionario = permitidoManterFuncionario;
		this.permitidoManterSetor = permitidoManterSetor;
		this.permitidoManterTarefa = permitidoManterTarefa;
		this.permitidoAtribuirTarefa = permitidoAtribuirTarefa;
		this.permitidoProgredirTarefa = permitidoProgredirTarefa;
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

	public String getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(String tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	public boolean isPermitidoManterMeta() {
		return permitidoManterMeta;
	}

	public void setPermitidoManterMeta(boolean permitidoManterMeta) {
		this.permitidoManterMeta = permitidoManterMeta;
	}

	public boolean isPermitidoAvaliacaoServidor() {
		return permitidoAvaliacaoServidor;
	}

	public void setPermitidoAvaliacaoServidor(boolean permitidoAvaliacaoServidor) {
		this.permitidoAvaliacaoServidor = permitidoAvaliacaoServidor;
	}

	public boolean isPermitidoAvaliacaoSupervisor() {
		return permitidoAvaliacaoSupervisor;
	}

	public void setPermitidoAvaliacaoSupervisor(boolean permitidoAvaliacaoSupervisor) {
		this.permitidoAvaliacaoSupervisor = permitidoAvaliacaoSupervisor;
	}

	public boolean isPermitidoManterFuncionario() {
		return permitidoManterFuncionario;
	}

	public void setPermitidoManterFuncionario(boolean permitidoManterFuncionario) {
		this.permitidoManterFuncionario = permitidoManterFuncionario;
	}

	public boolean isPermitidoManterSetor() {
		return permitidoManterSetor;
	}

	public void setPermitidoManterSetor(boolean permitidoManterSetor) {
		this.permitidoManterSetor = permitidoManterSetor;
	}

	public boolean isPermitidoManterTarefa() {
		return permitidoManterTarefa;
	}

	public void setPermitidoManterTarefa(boolean permitidoManterTarefa) {
		this.permitidoManterTarefa = permitidoManterTarefa;
	}

	public boolean isPermitidoAtribuirTarefa() {
		return permitidoAtribuirTarefa;
	}

	public void setPermitidoAtribuirTarefa(boolean permitidoAtribuirTarefa) {
		this.permitidoAtribuirTarefa = permitidoAtribuirTarefa;
	}

	public boolean isPermitidoProgredirTarefa() {
		return permitidoProgredirTarefa;
	}

	public void setPermitidoProgredirTarefa(boolean permitidoProgredirTarefa) {
		this.permitidoProgredirTarefa = permitidoProgredirTarefa;
	}
}
