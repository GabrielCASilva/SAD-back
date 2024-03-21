package com.trabalho.sad.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ProgressoMeta implements Avaliacao{
	
	private double indiceProdutividade;
	private double indiceAgilidade;
	private double indiceEficacia;
	
	private Meta metaAlvo = null;
	private List<Tarefa> tarefasAvaliacao = null; 
	
	
	public ProgressoMeta(Meta meta) {
		this.indiceProdutividade = 0;
		this.indiceAgilidade = 0;
		this.indiceEficacia = 0;
		
		this.metaAlvo = meta;
		this.tarefasAvaliacao =  new ArrayList<>();
	}

	@Override
	public void calcularAvaliacao() {
		this.obterTarefas();
		this.indiceProdutividade = calcularProdutividade();
		this.indiceAgilidade = calcularAgilidade();
		this.indiceEficacia = calcularEficacia();
	}

	@Override
	public void obterTarefas() {
		this.tarefasAvaliacao = this.metaAlvo.getTarefas();
	}

	@Override
	public void gerarRelatorio() {
		// TODO
		/* Utilizando os valores guardados nos indices, gera um relatório em arquivo
		* */
	}

	private double calcularProdutividade() {
		//TODO
		double resultado = 0;
		return resultado;
	}
	
	private double calcularAgilidade() {
		//TODO
		double resultado = 0;
		return resultado;
	}
	
	private double calcularEficacia() {
		//TODO
		double resultado = 0;
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
