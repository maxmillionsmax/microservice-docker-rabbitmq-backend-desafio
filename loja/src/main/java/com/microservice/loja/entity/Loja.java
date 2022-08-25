package com.microservice.loja.entity;

import com.microservice.loja.dto.LojaDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_loja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;

    public static Loja create(LojaDto lojaDto){
        return new ModelMapper().map(lojaDto, Loja.class);
    }

}
