package com.microservice.loja.service;

import com.microservice.loja.entity.Loja;
import com.microservice.loja.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Loja updateLoja(Loja loja){
        Optional<Loja> newLoja = lojaRepository.findById(loja.getId());
        if (newLoja.isPresent()){
            return lojaRepository.save(loja);
        }else {
            return null;
        }
    }
    public boolean deleteLoja(Long id){

        Optional<Loja> loja = lojaRepository.findById(id);
        if (loja.isPresent()){
            lojaRepository.delete(loja.get());
            return true;
        }else {
            return false;
        }
    }
    public Optional<Loja> findById(Long id){
        return lojaRepository.findById(id);
    }
    public List<Loja> findAll(){
        return lojaRepository.findAll();
    }
}
