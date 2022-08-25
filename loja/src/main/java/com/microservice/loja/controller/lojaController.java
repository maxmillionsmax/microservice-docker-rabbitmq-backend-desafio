package com.microservice.loja.controller;

import com.microservice.loja.dto.LojaDto;
import com.microservice.loja.entity.Loja;
import com.microservice.loja.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/loja")
public class LojaController {

    private final LojaService lojaService;

    @Autowired
    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertLoja(@RequestBody LojaDto lojaDto){

        return ResponseEntity.ok(lojaService.insertLoja(Loja.create(lojaDto)));
    }

}

