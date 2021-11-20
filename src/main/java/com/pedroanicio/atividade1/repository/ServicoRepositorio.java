package com.pedroanicio.atividade1.repository;

import com.pedroanicio.atividade1.domain.Servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepositorio extends JpaRepository<Servico, Long>{
    
}
