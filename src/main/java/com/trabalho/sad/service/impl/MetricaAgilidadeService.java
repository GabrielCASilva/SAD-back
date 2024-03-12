package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Tarefa;
import com.trabalho.sad.model.entities.status.SituacaoServico;
import com.trabalho.sad.model.repository.TarefaRepository;
import com.trabalho.sad.service.TarefaService;

/**
 * calcula a diferença em dias entre as datas de criação e conclusão de cada
 * tarefa e divide pelo conjunto de tarefas
 */
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