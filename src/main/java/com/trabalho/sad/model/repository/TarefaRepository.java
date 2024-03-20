package com.trabalho.sad.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.sad.model.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
