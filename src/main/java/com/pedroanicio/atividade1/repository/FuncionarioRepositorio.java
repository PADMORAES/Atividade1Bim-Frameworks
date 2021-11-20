package com.pedroanicio.atividade1.repository;

import com.pedroanicio.atividade1.domain.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{
    
}
