package com.microservice.catalogo.controller;

import com.microservice.catalogo.dto.ProdudoDto;
import com.microservice.catalogo.entity.Produto;
import com.microservice.catalogo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class CatalogoController {

    private final ProdutoService produtoService;

    @Autowired
    public CatalogoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertProduto(@RequestBody ProdudoDto produdoDto) {

        try {
            return ResponseEntity.ok(produtoService.insertProduto(Produto.create(produdoDto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduto(@PathVariable("id") Long id, @RequestBody ProdudoDto produdoDto){
        Produto produto = Produto.create(produdoDto);
        produto.setId(id);
        Produto updatedProduto =  produtoService.updateProduto(produto);
        return Objects.nonNull(updatedProduto) ?
                ResponseEntity.ok(updatedProduto) :
                ResponseEntity.notFound().build();

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduto(@PathVariable("id") Long id){

        return produtoService.deleteProduto(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Optional<Produto> produto = produtoService.findById(id);
        return produto.isPresent() ?
                ResponseEntity.ok(produto.get()) :
                ResponseEntity.notFound().build();
    }
}