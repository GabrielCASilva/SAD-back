package com.trabalho.sad.api.dto;

import java.time.LocalDate;

import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.model.entities.Funcionario;

public class FuncionarioDTO {

	/* Atributos 
	 ***************************************************************************************************/
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private char sexo;
	private Long cpf;
	private Long cep;
	private String endereco;
	private Long telefone;
	private String foto;
	private String email;
	private LocalDate dataCadastro;
	private String login;
	private String senhaHash;
	private String situacao;

	private CargoDTO cargo = new CargoDTO();
	
	
	/* Construtor 
	 ***************************************************************************************************/
	public FuncionarioDTO() {
		super();
	}
	
	
	public FuncionarioDTO(Long id, String nome, LocalDate dataNascimento, char sexo, Long cpf, Long cep,
			String endereco, Long telefone, String foto, String email, LocalDate dataCadastro, String login,
			String senhaHash, String situacao, CargoDTO cargo) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.cep = cep;
		this.endereco = endereco;
		this.telefone = telefone;
		this.foto = foto;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.login = login;
		this.senhaHash = senhaHash;
		this.situacao = situacao;
		this.cargo = cargo;
	}

	public FuncionarioDTO(Funcionario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.dataNascimento = entity.getDataNascimento();
		this.sexo = entity.getSexo();
		this.cpf = entity.getCpf();
		this.cep = entity.getCep();
		this.endereco = entity.getEndereco();
		this.telefone = entity.getTelefone();
		this.foto = entity.getFoto();
		this.email = entity.getEmail();
		this.dataCadastro = entity.getDataCadastro();
		this.login = entity.getLogin();
		this.senhaHash = entity.getSenhaHash();
		this.situacao = entity.getSituacao();
		this.cargo = new CargoDTO(entity.getCargo());
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public CargoDTO getCargo() {
		return cargo;
	}


	public void setCargo(CargoDTO cargo) {
		this.cargo = cargo;
	}
	
}
