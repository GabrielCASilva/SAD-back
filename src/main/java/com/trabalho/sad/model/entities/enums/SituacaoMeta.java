package com.trabalho.sad.model.entities.enums;

public enum SituacaoMeta {


	ATIVO 	    ("ATIVO"),
	INATIVO     ("INATIVO"),
	EM_ANDAMENTO("EM ANDAMENTO"),
	CONCLUÍDO   ("CONCLUÍDO");

	
	private String code;
	
	private SituacaoMeta(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
