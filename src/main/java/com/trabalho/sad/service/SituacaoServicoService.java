package com.trabalho.sad.service;

import java.util.List;

import com.trabalho.sad.model.entities.SituacaoServico;

public interface SituacaoServicoService {
	
	SituacaoServico cadastrar(SituacaoServico situacaoServicoParam);
	
	SituacaoServico atualizar(SituacaoServico situacaoServicoParam);
	
	void deletar(SituacaoServico situacaoServicoParam);
	
	List<SituacaoServico> buscar(SituacaoServico situacaoServicoParam);

}
