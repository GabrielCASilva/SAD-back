package com.trabalho.sad.model.entities;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoSuperior implements Avaliacao {
	
	private double indiceProdutividade;
	private double indiceAgilidade;
	private double indiceEficacia;
	private double indiceComprometimento;
	
	private Funcionario funcionarioAlvo = null;
	private List<Tarefa> tarefasAvaliacao = null; 
	
	
	public AvaliacaoSuperior(Funcionario funcionarioSuperior) {
		this.indiceProdutividade = 0;
		this.indiceAgilidade = 0;
		this.indiceEficacia = 0;
		this.indiceComprometimento = 0;
		
		this.funcionarioAlvo = funcionarioSuperior;
		this.tarefasAvaliacao =  new ArrayList<>();
	}

	
	@Override
	public void calcularAvaliacao() {
		this.obterTarefas();
		this.indiceProdutividade = calcularProdutividade();
		this.indiceAgilidade = calcularAgilidade();
		this.indiceEficacia = calcularEficacia();
		this.indiceComprometimento = calcularComprometimento();
	}

	@Override
	public void obterTarefas() {
		//TODO 
		/* Verificar se tarefasSupervisor corresponde de fato com o q eu imagino
		 * */
		this.tarefasAvaliacao = this.funcionarioAlvo.getTarefasSupervisor();
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
	
	private double calcularComprometimento() {
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

	public double getIndiceComprometimento() {
		return indiceComprometimento;
	}

}
