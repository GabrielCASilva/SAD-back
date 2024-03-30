package com.trabalho.sad.model.entities.status;

public enum SituacaoFuncionario {
	
	ATIVO("Ativo"),
	INATIVO("Inativo"),
	LICENCA("Em licença");
	
	private String situacao;
	
	private SituacaoFuncionario(String status) {
		this.situacao = status;
	}
	
	@Override
	public String toString() {
		return this.situacao;
	}
}
