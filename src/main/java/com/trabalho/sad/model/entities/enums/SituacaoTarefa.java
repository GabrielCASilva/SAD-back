package com.trabalho.sad.model.entities.enums;

public enum SituacaoTarefa {

	ATIVO 	    ("ATIVO"),
	INATIVO     ("INATIVO"),
	EM_ANDAMENTO("EM_ANDAMENTO"),
	CONCLUÍDO   ("CONCLUÍDO");
	
	private String code;
	
	private SituacaoTarefa(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
