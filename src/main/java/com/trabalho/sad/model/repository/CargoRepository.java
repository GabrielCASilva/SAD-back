package com.trabalho.sad.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.sad.model.entities.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{
    List<Cargo> findAllById(Long id);
}
