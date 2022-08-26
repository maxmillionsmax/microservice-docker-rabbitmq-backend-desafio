package com.microservice.loja.controller;

import com.microservice.loja.dto.LojaDto;
import com.microservice.loja.entity.Loja;
import com.microservice.loja.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/loja")
public class LojaController {

    private final LojaService lojaService;

    @Autowired
    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertLoja(@RequestBody LojaDto lojaDto) {

        try {
            return ResponseEntity.ok(lojaService.insertLoja(Loja.create(lojaDto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateLoja(@PathVariable("id") Long id, @RequestBody LojaDto lojaDto){

        Loja loja = Loja.create(lojaDto);
        loja.setId(id);
        Loja updateLoja =  lojaService.updateLoja(loja);
        return Objects.nonNull(updateLoja) ?
                ResponseEntity.ok(updateLoja) :
                ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLoja(@PathVariable("id") Long id){

        return lojaService.deleteLoja(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
    @GetMapping("/find/")
    public List<Loja> findAll(){
        return lojaService.findAll();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){

        Optional<Loja> loja =  lojaService.findById(id);
        return loja.isPresent() ?
                ResponseEntity.ok(loja.get()) :
                ResponseEntity.notFound().build();
    }
}

