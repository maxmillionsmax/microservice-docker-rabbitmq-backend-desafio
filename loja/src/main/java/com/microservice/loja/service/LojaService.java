package com.microservice.loja.service;

import com.microservice.loja.entity.Loja;
import com.microservice.loja.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    private final LojaRepository lojaRepository;

    @Autowired
    public LojaService(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public Loja insertLoja(Loja loja){
        return lojaRepository.save(loja);
    }
}
