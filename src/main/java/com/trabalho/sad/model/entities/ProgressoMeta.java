package com.trabalho.sad.model.entities;

import java.time.temporal.ChronoUnit;
import java.util.List;

import com.trabalho.sad.model.entities.enums.SituacaoServico;

public class ProgressoMeta implements Avaliacao{
	
	private double indiceProdutividade;
	private double indiceAgilidade;
	private double indiceEficacia;
	
	private Meta metaAlvo = null;
	private List<Tarefa> tarefasAvaliacao = null; 
	
	
	public ProgressoMeta(Meta meta, List<Tarefa> tarefasEscopo) {
		this.indiceProdutividade = 0;
		this.indiceAgilidade = 0;
		this.indiceEficacia = 0;
		
		this.metaAlvo = meta;
		this.tarefasAvaliacao = tarefasEscopo;
	}

	@Override
	public boolean calcularAvaliacao() {
		if(!this.obterTarefas()) {
			return false;
		}
		this.indiceProdutividade = calcularProdutividade();
		this.indiceAgilidade = calcularAgilidade();
		this.indiceEficacia = calcularEficacia();
		
		return true;
	}

	@Override
	public boolean obterTarefas() {
		
		if(this.tarefasAvaliacao == null) {
			return false;
		}
		
		if(this.tarefasAvaliacao.size() == 0) {
			return false;
		}
		
		return true;
	}

	@Override
	public void gerarRelatorio() {
		// TODO
		/* Utilizando os valores guardados nos indices, gera um relatório em arquivo
		* */
	}

	private double calcularProdutividade() {
		double resultado = 0;
		double tarefasConcluidas = 0;
		
		/* Percorrer lista de tarefas */
		for(Tarefa tarefa : this.tarefasAvaliacao) {
				/* Obtendo quantidade de tarefas concluídas */
			if(tarefa.getSituacao() == SituacaoServico.CONCLUÍDO) {
				tarefasConcluidas++;
			}
		}
		/* Produtividade = Quantidade de tarefas concluídas, pelo total de tarefas */
		resultado = tarefasConcluidas / this.tarefasAvaliacao.size();
		return resultado;
	}
	
	private double calcularAgilidade() {
		double resultado = 0;
		long diasAgilidade = 0;
		
		/* Percorrer lista de tarefas */
		for(Tarefa tarefa : this.tarefasAvaliacao) {
				/* Verifica se tarefa foi concluída */
			if(tarefa.getSituacao() == SituacaoServico.CONCLUÍDO) {
					/* Acumula diferença entre data de conclusão e data de criação, para cada tarefa */
				diasAgilidade = diasAgilidade + ChronoUnit.DAYS.between(tarefa.getDataCriacao(), tarefa.getDataConclusao());
			}
		}
		
			/* Agilidade = Resultado de diasAgilidade, por total de tarefas */
		resultado = diasAgilidade / this.tarefasAvaliacao.size();
		return resultado;
	}
	
	private double calcularEficacia() {
		double resultado = 0;
		long diasEficacia = 0;
		
			/* Percorrer lista de tarefas */
		for(Tarefa tarefa : this.tarefasAvaliacao) {
				/* Verifica se tarefa foi concluída */
			if(tarefa.getSituacao() == SituacaoServico.CONCLUÍDO) {
					/* Acumula diferença entre data de conclusão prevista e data de conclusão efetiva, 
					 * para cada tarefa */
				diasEficacia = diasEficacia + ChronoUnit.DAYS.between(tarefa.getDataConclusao(), tarefa.getDataPrevistaConclusao());
			}
		}
		
			/* Eficácia = Resultado de diasEficacia, por total de tarefas */
		resultado = diasEficacia / this.tarefasAvaliacao.size();
		return resultado;
	}

	
	public double getIndiceProdutividade() {
		return indiceProdutividade;
	}

	public double getIndiceAgilidade() {
		return indiceAgilidade;
	}

	public double getIndiceEficacia() {
		return indiceEficacia;
	}
	
}
