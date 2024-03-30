package com.trabalho.sad.model.entities.enums;

public enum CategoriaAvaliacao {

	NENHUM 	 ("NENHUM"),
	SUPERIOR ("SUPERIOR"),
	EXECUTOR ("EXECUTOR");
	
	private String code;
	
	private CategoriaAvaliacao(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
