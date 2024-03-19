package com.trabalho.sad.service.impl;

import java.util.List;
import java.time.temporal.ChronoUnit;

import com.trabalho.sad.model.entities.Tarefa;

public class MetricaAgilidadeService {
    public double calcularMetricaAgilidade(List<Tarefa> tarefas) {
        double somaDiferencas = 0.0;

        for (Tarefa tarefa : tarefas) {
            long diferenca = ChronoUnit.DAYS.between(tarefa.getDataCriacao(), tarefa.getDataConclusao());
            somaDiferencas += diferenca;
        }
        return somaDiferencas / tarefas.size();
    }
}