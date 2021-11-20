package com.pedroanicio.atividade1.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Principal {

    private final Logger log = LoggerFactory.getLogger(Principal.class);

    @GetMapping(value={"/", "/login"})
    public ModelAndView home() {
        log.info("Abri a Home");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

