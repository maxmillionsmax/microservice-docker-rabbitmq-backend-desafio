package com.microservice.catalogo.entity;

import com.microservice.catalogo.dto.ProdudoDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String produto;
    private String categoria;
    private Double preco;

    public static Produto create(ProdudoDto produdoDto){
        return new ModelMapper().map(produdoDto, Produto.class);
    }
}
