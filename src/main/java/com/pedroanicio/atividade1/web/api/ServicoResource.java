package com.pedroanicio.atividade1.web.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.pedroanicio.atividade1.domain.Servico;
import com.pedroanicio.atividade1.service.ServicoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/Servicos")
public class ServicoResource {
    private final Logger log = LoggerFactory.getLogger(ServicoResource.class);
    private final ServicoService sService;

    public ServicoResource(ServicoService sService){
        this.sService = sService;
    }    

    @GetMapping(path = "/criar/{name}")
	public String helloApp(@PathVariable String name){
		Servico f = new Servico();
        f.setNomeCliente(name);
        sService.save(f);
        return "criou";
	}
    
    /**Primeira aba visualizada na /servicos
     * possui uma lista de todos os servicos registrados
     */
    @GetMapping("/")
    public ResponseEntity<List<Servico>> getServicos(){
        List<Servico> lista = sService.findAllList();
        if(lista.size() > 0) {
            return ResponseEntity.ok().body(lista);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    /**Aba visualizada na /servicos/{numero}
     * Possui listado o servicos com ID = numero
     */
    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServico(@PathVariable Long id) {
        log.debug("REST request to get Servico : {}", id);
        Optional<Servico> Servico = sService.findOne(id);
        if(Servico.isPresent()) {
            return ResponseEntity.ok().body(Servico.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    /**Aba modificada do /servicos
     * NAO CARREGA O MEU BD AAAAAAAAAAAAAAAAAAAAAAAAAAAA
     */
    @PostMapping("/")
    public ResponseEntity<Servico> createServico(@RequestBody Servico servico) throws URISyntaxException {
        log.debug("REST request to save Servico : {}", servico);
        if (servico.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Um novo servico não pode terum ID");
        }
        Servico result = sService.save(servico);
        return ResponseEntity.created(new URI("/api/servicos/" + result.getId()))
                .body(result);
    }


    /**Aba modificada do /servicos
     * NAO CARREGA O MEU BD AAAAAAAAAAAAAAAAAAAAAAAAAAAA
     */
    @PutMapping("/")
    public ResponseEntity<Servico> updateServico(@RequestBody Servico servico) throws URISyntaxException {
        log.debug("REST request to update servico : {}", servico);
        if (servico.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid Servico id null");
        }
        Servico result = sService.save(servico);
        return ResponseEntity.ok()
                .body(result);
    }


     /** Aba de deletar em /servicos
     * ESPERAR O BD FUNCIONAR PROXIMA AULA
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicos(@PathVariable Long id) {
        log.debug("REST request to delete Servicos : {}", id);

        sService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
