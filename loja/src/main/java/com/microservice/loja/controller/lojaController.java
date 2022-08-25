package com.microservice.loja.controller;

import com.microservice.loja.dto.LojaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/loja")
public class lojaController {

    @PostMapping("/insert")
    public LojaDto insertLoja(@RequestBody LojaDto lojaDto){
        System.out.println(lojaDto);
        return lojaDto;
    }

}

