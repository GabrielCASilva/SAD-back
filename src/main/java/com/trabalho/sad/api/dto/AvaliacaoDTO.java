package com.trabalho.sad.api.dto;

import java.util.List;

import com.trabalho.sad.model.entities.Tarefa;

public class AvaliacaoDTO {
	private double indiceProdutividade;
	private double indiceAgilidade;
	private double indiceEficacia;
	private double indiceComprometimento;
    private List<Tarefa> tarefasAvaliacao = null; 

    public AvaliacaoDTO(){

    }

    public AvaliacaoDTO(double indiceProdutividade, double indiceAgilidade, double indiceEficacia,
            double indiceComprometimento, List<Tarefa> tarefasAvaliacao) {
        this.indiceProdutividade = indiceProdutividade;
        this.indiceAgilidade = indiceAgilidade;
        this.indiceEficacia = indiceEficacia;
        this.indiceComprometimento = indiceComprometimento;
        this.tarefasAvaliacao = tarefasAvaliacao;
    }

    public AvaliacaoDTO(double indiceProdutividade, double indiceAgilidade, double indiceEficacia, 
            List<Tarefa> tarefasAvaliacao) {
        this.indiceProdutividade = indiceProdutividade;
        this.indiceAgilidade = indiceAgilidade;
        this.indiceEficacia = indiceEficacia;
        this.tarefasAvaliacao = tarefasAvaliacao;
    }

    public double getIndiceProdutividade() {
        return indiceProdutividade;
    }

    public void setIndiceProdutividade(double indiceProdutividade) {
        this.indiceProdutividade = indiceProdutividade;
    }

    public double getIndiceAgilidade() {
        return indiceAgilidade;
    }

    public void setIndiceAgilidade(double indiceAgilidade) {
        this.indiceAgilidade = indiceAgilidade;
    }

    public double getIndiceEficacia() {
        return indiceEficacia;
    }

    public void setIndiceEficacia(double indiceEficacia) {
        this.indiceEficacia = indiceEficacia;
    }

    public double getIndiceComprometimento() {
        return indiceComprometimento;
    }

    public void setIndiceComprometimento(double indiceComprometimento) {
        this.indiceComprometimento = indiceComprometimento;
    }

    public List<Tarefa> getTarefasAvaliacao() {
        return tarefasAvaliacao;
    }

    public void setTarefasAvaliacao(List<Tarefa> tarefasAvaliacao) {
        this.tarefasAvaliacao = tarefasAvaliacao;
    }


}
