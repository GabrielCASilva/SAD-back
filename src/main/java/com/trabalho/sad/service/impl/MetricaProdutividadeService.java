package com.trabalho.sad.service.impl;

import java.util.List;

import com.trabalho.sad.model.entities.Tarefa;
import com.trabalho.sad.model.entities.status.SituacaoServico;

public class MetricaProdutividadeService {
    public double calcularMetricaProdutividade(List<Tarefa> tarefas) {
        int totalTarefasConcluidas = 0;

        for (Tarefa tarefa : tarefas) {
            String situacao = tarefa.getSituacao();
            if (situacao == SituacaoServico.CONCLUIDA.toString()) {

                totalTarefasConcluidas++;
            }
        }
        if (tarefas.size() == 0) {
            return 0;
        }

        return (double) totalTarefasConcluidas / tarefas.size();
    }
}
