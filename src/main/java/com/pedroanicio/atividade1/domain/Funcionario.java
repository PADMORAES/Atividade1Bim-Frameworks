package com.pedroanicio.atividade1.domain;

import java.time.Instant;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/** Banco de dados com problema, nao é gerado. 
 * 1 - n falta log4j.xml
 * 2 - n tem erro de linguagem (aparente)
 * 3 - procurar mais
 */
@Entity(name = "table_Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 64)
    private String nome;

    private Instant dtNasc;
    private String cpf;
    private String Telefone;
    private String CEP;
    private Boolean isActive;
    private String funcao;
    private String rua;
    private String cidade;
    private int numero;

    public static Funcionario parseNote(String line) {
        String[] text = line.split(",");
        Funcionario note = new Funcionario();
        note.setId(Long.parseLong(text[0]));
        note.setNome(text[1]);
        return note;
    }

}
