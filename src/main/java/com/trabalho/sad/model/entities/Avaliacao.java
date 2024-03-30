package com.trabalho.sad.model.entities;

import java.time.LocalDate;

public interface Avaliacao {

	public boolean calcularAvaliacao();
	public boolean obterTarefas();
	public void gerarRelatorio(Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim);
	public void gerarRelatorio(Meta meta, LocalDate dataInicio, LocalDate dataFim);
}
