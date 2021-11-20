package com.pedroanicio.atividade1.service;


import com.pedroanicio.atividade1.domain.Servico;
import com.pedroanicio.atividade1.repository.ServicoRepositorio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    private final Logger log = LoggerFactory.getLogger(ServicoService.class);

    private final ServicoRepositorio ServicoRepositorio;

    public ServicoService(ServicoRepositorio ServicoRepositorio) {
        this.ServicoRepositorio = ServicoRepositorio;
    }

    public List<Servico> findAllList(){
        log.debug("Request to get All Servico");
        return ServicoRepositorio.findAll();
    }

    public Optional<Servico> findOne(Long id) {
        log.debug("Request to get Servico : {}", id);
        return ServicoRepositorio.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Servico : {}", id);
        ServicoRepositorio.deleteById(id);
    }

    public Servico save(Servico Servico) {
        log.debug("Pedido para salvar Servico : {}", Servico);
        Servico = ServicoRepositorio.save(Servico);
        return Servico;
    }

    public List<Servico> saveAll(List<Servico> Servicos) {
        log.debug("Pedrido para salvar Servicos : {}", Servicos);
        Servicos = ServicoRepositorio.saveAll(Servicos);
        return Servicos;
    }


}
