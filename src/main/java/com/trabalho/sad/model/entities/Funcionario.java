package com.trabalho.sad.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "dataNascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(name = "sexo", nullable = false)
	private char sexo;
	
	@Column(name = "cpf", nullable = false)
	private Long cpf;
	
	@Column(name = "cep", nullable = false)
	private Long cep;
	
	@Column(name = "endereco", nullable = false)
	private String endereco;
	
	@Column(name = "telefone", nullable = false)
	private Long telefone;
	
	//TODO
	//@Column(name = "foto", nullable = false)
	//private String foto;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "dataCadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "senhaHash", nullable = false)
	private String senhaHash;
	
	@Column(name = "idCargo", nullable = false)
	private Long idCargo;
	
	@Column(name = "idSetor", nullable = false)
	private Long idSetor;
	
	@Column(name = "idSituacaoFuncionario", nullable = false)
	private Long idSituacaoFuncionario;

	/* Construtor 
	 ***************************************************************************************************/
	public Funcionario(Long id, String nome, LocalDate dataNascimento, char sexo, Long cpf, Long cep, String endereco,
			Long telefone, String email, LocalDate dataCadastro, String login, String senhaHash, Long idCargo,
			Long idSetor, Long idSituacaoFuncionario) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.cep = cep;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.login = login;
		this.senhaHash = senhaHash;
		this.idCargo = idCargo;
		this.idSetor = idSetor;
		this.idSituacaoFuncionario = idSituacaoFuncionario;
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


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public Long getCep() {
		return cep;
	}


	public void setCep(Long cep) {
		this.cep = cep;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Long getTelefone() {
		return telefone;
	}


	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenhaHash() {
		return senhaHash;
	}


	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}


	public Long getIdCargo() {
		return idCargo;
	}


	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}


	public Long getIdSetor() {
		return idSetor;
	}


	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}


	public Long getIdSituacaoFuncionario() {
		return idSituacaoFuncionario;
	}


	public void setIdSituacaoFuncionario(Long idSituacaoFuncionario) {
		this.idSituacaoFuncionario = idSituacaoFuncionario;
	}
	
}
