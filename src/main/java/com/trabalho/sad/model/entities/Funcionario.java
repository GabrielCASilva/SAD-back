package com.trabalho.sad.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trabalho.sad.model.entities.enums.SituacaoFuncionario;

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
@Table(name = "funcionario")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

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
	
	@Column(name = "foto", nullable = false)
	private String foto;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "dataCadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "senhaHash", nullable = false)
	private String senhaHash; 

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", nullable = false)
	private SituacaoFuncionario situacao;

	@ManyToOne
	@JsonIgnoreProperties("funcionarios")
	@JoinColumn(name = "setor_id")
	private Setor setor;

	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "diretor")
	private List<Meta> metas = new ArrayList<>();
		
	@JsonIgnore
	@OneToMany(mappedBy = "supervisor")
	private List<Tarefa> tarefasSupervisor = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "servidor")
	private List<Tarefa> tarefasServidor = new ArrayList<>();
	
	public Funcionario() {
	}

	public Funcionario(String nome, LocalDate dataNascimento, char sexo, Long cpf, Long cep, String endereco, Long telefone, String foto, String email, LocalDate dataCadastro, String login, String senhaHash, SituacaoFuncionario situacao, Setor setor, Cargo cargo) {
		super();
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
		this.setor = setor;
		this.cargo = cargo;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	
	public SituacaoFuncionario getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoFuncionario situacao) {
		if (situacao != null) {
			this.situacao = situacao;
		}
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

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public List<Meta> getMetas() {
		return metas;
	}

	public void setMetas(List<Meta> metas) {
		this.metas = metas;
	}

	public List<Tarefa> getTarefasSupervisor() {
		return tarefasSupervisor;
	}

	public void setTarefasSupervisor(List<Tarefa> tarefasSupervisor) {
		this.tarefasSupervisor = tarefasSupervisor;
	}

	public List<Tarefa> getTarefasServidor() {
		return tarefasServidor;
	}

	public void setTarefasServidor(List<Tarefa> tarefasServidor) {
		this.tarefasServidor = tarefasServidor;
	}

}
