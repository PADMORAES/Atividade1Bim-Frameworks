package com.pedroanicio.atividade1.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.pedroanicio.atividade1.domain.Funcionario;
import com.pedroanicio.atividade1.service.FuncionarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {
    private final Logger log = LoggerFactory.getLogger(FuncionarioResource.class);

    private final FuncionarioService fService;

    public FuncionarioResource(FuncionarioService fService){
        this.fService = fService;
    }    

    @GetMapping(path = "/criar/{name}")
	public String helloApp(@PathVariable String name){
		Funcionario f = new Funcionario();
        f.setNome(name);
        fService.save(f);
        return "criou";
	}

    /**Primeira aba visualizada na /funcionarios
     * possui uma lista de todos os funcionarios registrados
     */
    @GetMapping("/")
    public ResponseEntity<List<Funcionario>> getFuncionarios(){
        List<Funcionario> lista = fService.findAllList();
        if(lista.size() > 0) {
            return ResponseEntity.ok().body(lista);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    /**Aba visualizada na /funcionarios/{numero}
     * Possui listado o  funcionario com ID = numero
     */
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long id) {
        log.debug("REST request to get Funcionario : {}", id);
        Optional<Funcionario> funcionario = fService.findOne(id);
        if(funcionario.isPresent()) {
            return ResponseEntity.ok().body(funcionario.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }


    /**Aba modificada do /funcionarios
     * NAO CARREGA O MEU BD AAAAAAAAAAAAAAAAAAAAAAAAAAAA
     */
    @PutMapping("/")
    public ResponseEntity<Funcionario> updateFuncionario(@RequestBody Funcionario funcionario) throws URISyntaxException {
        log.debug("REST request to update Funcionario : {}", funcionario);
        if (funcionario.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid Funcionario id null");
        }
        Funcionario result = fService.save(funcionario);
        return ResponseEntity.ok()
                .body(result);
    }

    /** Aba de deletar em /funcionarios
     * ESPERAR O BD FUNCIONAR PROXIMA AULA
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        log.debug("REST request to delete Funcionario : {}", id);

        fService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
