package com.trabalho.sad.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	/* Atributos 
	 ***************************************************************************************************/
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
	
	@Column(name = "foto")
	private String foto;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "dataCadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "senhaHash", nullable = false)
	private String senhaHash;
	
	@Column(name = "situacao", nullable=false)
	private String situacao;
	
	/* Atributos - Mapping
	 ***************************************************************************************************/
	@ManyToOne(optional = true)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "setorParticipa_id")
	private Setor setorParticipa;
	
	@OneToOne(mappedBy = "supervisor")
	private Setor setorSupervisionado;
	
	@OneToMany(mappedBy = "responsavel")
	private List<Meta> metasResponsavel = new ArrayList<>();
	
	@OneToMany(mappedBy = "funcionarioAlocado")
	private List<Tarefa> tarefasAlocado = new ArrayList<>();
	
	@OneToMany(mappedBy = "funcionarioResponsavel")
	private List<Tarefa> tarefasResponsavel = new ArrayList<>();

	
	/* Construtor 
	 ***************************************************************************************************/
	public Funcionario(Long id, String nome, LocalDate dataNascimento, char sexo, Long cpf, Long cep, String endereco,
			Long telefone, String foto, String email, LocalDate dataCadastro, String login, String senhaHash, 
			String situacao) {
		super();
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
	}

	public Funcionario() {
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


	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public Setor getSetorParticipa() {
		return setorParticipa;
	}

	public Setor getSetorSupervisionado() {
		return setorSupervisionado;
	}

	public List<Meta> getMetasResponsavel() {
		return metasResponsavel;
	}

	public List<Tarefa> getTarefasAlocado() {
		return tarefasAlocado;
	}

	public List<Tarefa> getTarefasResponsavel() {
		return tarefasResponsavel;
	}
	
}
