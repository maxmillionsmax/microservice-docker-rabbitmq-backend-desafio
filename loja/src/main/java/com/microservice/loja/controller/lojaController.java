package com.microservice.loja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/loja")
public class lojaController {

    @GetMapping("/teste")
    public String olaTeste(){
        return "Teste executado com sucesso";
    }
}

