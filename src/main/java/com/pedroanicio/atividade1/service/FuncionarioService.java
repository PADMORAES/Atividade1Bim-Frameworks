package com.pedroanicio.atividade1.service;


import com.pedroanicio.atividade1.domain.Funcionario;
import com.pedroanicio.atividade1.repository.FuncionarioRepositorio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final Logger log = LoggerFactory.getLogger(FuncionarioService.class);

    private final FuncionarioRepositorio FuncionarioRepositorio;

    public FuncionarioService(FuncionarioRepositorio FuncionarioRepositorio) {
        this.FuncionarioRepositorio = FuncionarioRepositorio;
    }

    public List<Funcionario> findAllList(){
        log.debug("Request to get All Funcionario");
        return FuncionarioRepositorio.findAll();
    }

    public Optional<Funcionario> findOne(Long id) {
        log.debug("Request to get Funcionario : {}", id);
        return FuncionarioRepositorio.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Funcionario : {}", id);
        FuncionarioRepositorio.deleteById(id);
    }

    public Funcionario save(Funcionario Funcionario) {
        log.debug("Pedido para salvar Funcionario : {}", Funcionario);
        Funcionario = FuncionarioRepositorio.save(Funcionario);
        return Funcionario;
    }

    public List<Funcionario> saveAll(List<Funcionario> Funcionarios) {
        log.debug("Pedrido para salvar Funcionarios : {}", Funcionarios);
        Funcionarios = FuncionarioRepositorio.saveAll(Funcionarios);
        return Funcionarios;
    }


}
