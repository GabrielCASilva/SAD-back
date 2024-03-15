package com.trabalho.sad.model.entities.enums;

public enum SituacaoFuncionario {

	ATIVO 	("ATIVO"),
	INATIVO ("INATIVO"),
	LICENÇA	("LICENÇA");

	
	private String code;
	
	private SituacaoFuncionario(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
