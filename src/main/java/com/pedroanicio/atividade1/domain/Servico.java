package com.pedroanicio.atividade1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/** Mesmo erro que Funcionario :( */
@Entity(name = "tbServico")
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomeCliente;
    private String cpf;
    private String Telefone;
    private String email;
    /**O tipo de servico seria: Manicure, pedicure. */
    private String tipo;
    /**Qual funcionario faria o atendimento */
    private String nomeAtendente;
    private Boolean isActive;

}
