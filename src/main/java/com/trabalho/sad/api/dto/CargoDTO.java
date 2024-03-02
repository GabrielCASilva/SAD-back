package com.trabalho.sad.api.dto;

public class CargoDTO {
	
	/* Atributos 
	 ***************************************************************************************************/
	private Long id;
	private String nome;
	private String tipoAvaliacao;
	private boolean permitidoManterMeta;
	private boolean permitidoAvaliacaoServidor;
	private boolean permitidoAvaliacaoSupervisor;
	private boolean permitidoManterFuncionario;
	private boolean permitidoManterSetor;
	private boolean permitidoManterTarefa;
	private boolean permitidoAtribuirTarefa;
	private boolean permitidoProgredirTarefa;
	
	
	/* Construtor 
	 ***************************************************************************************************/
	public CargoDTO() {
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
