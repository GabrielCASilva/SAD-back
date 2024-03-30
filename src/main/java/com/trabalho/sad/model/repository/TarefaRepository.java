package com.trabalho.sad.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.model.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	   @Query("SELECT t FROM Tarefa t WHERE t.servidor = :servidor AND t.dataCriacao >= :dataInicio AND t.dataCriacao <= :dataFim")
	   List<Tarefa> findByFuncionarioServidorAndPeriodo(@Param("servidor") Funcionario servidor, @Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
	   
	   @Query("SELECT t FROM Tarefa t WHERE t.supervisor = :supervisor AND t.dataCriacao >= :dataInicio AND t.dataCriacao <= :dataFim")
	   List<Tarefa> findByFuncionarioSupervisorAndPeriodo(@Param("supervisor") Funcionario supervisor, @Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
	   
	   @Query("SELECT t FROM Tarefa t WHERE t.meta = :meta AND t.dataCriacao >= :dataInicio AND t.dataCriacao <= :dataFim")
	   List<Tarefa> findByTarefasDaMetaNoPeriodo(@Param("meta") Meta meta, @Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

}
