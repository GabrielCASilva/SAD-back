package com.trabalho.sad.model.entities.status;

public enum SituacaoServico {
	
	ATIVA("Ativa"),
	INATIVA("Inativa"),
	EM_ANDAMENTO("Em andamento"),
	CONCLUIDA("Concluída");
	
	private String situacao;
	
	private SituacaoServico(String status) {
		this.situacao = status;
	}
	
	@Override
	public String toString() {
		return this.situacao;
	}
}
