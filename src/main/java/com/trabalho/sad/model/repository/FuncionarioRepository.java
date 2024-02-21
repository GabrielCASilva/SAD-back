package com.trabalho.sad.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.sad.model.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
