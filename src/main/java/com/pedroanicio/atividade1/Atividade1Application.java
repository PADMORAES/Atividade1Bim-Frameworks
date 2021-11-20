package com.pedroanicio.atividade1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Atividade1Application {

	private static final Logger log = LoggerFactory.getLogger(Atividade1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Atividade1Application.class, args);
	
		log.info("--->Minha Primeira Aplicação<------");
	  }	

}
