package com.microservice.catalogo.service;

import com.microservice.catalogo.entity.Produto;
import com.microservice.catalogo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto insertProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Produto produto){
        Optional<Produto> newProduto = produtoRepository.findById(produto.getId());
        if (newProduto.isPresent()){
            return produtoRepository.save(produto);
        }else {
            return null;
        }
    }
    public boolean deleteProduto(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            produtoRepository.delete(produto.get());
            return true;
        }else {
            return false;
        }
    }
    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }
}
