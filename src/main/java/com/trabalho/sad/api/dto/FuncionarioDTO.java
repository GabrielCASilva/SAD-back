package com.trabalho.sad.api.dto;

import java.time.Instant;

public class FuncionarioDTO {
		
		private Long id;	
		private String nome;
		private Instant dataNascimento;
		private char sexo;
		private Long cpf;
		/*
		private Long cep;
		private String endereco;
		private Long telefone;
		private String foto;
		private String email;
		private LocalDate dataCadastro;
		private String login;
		private String senhaHash; 
		*/
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
		public Instant getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Instant dataNascimento) {
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
		
		
}
