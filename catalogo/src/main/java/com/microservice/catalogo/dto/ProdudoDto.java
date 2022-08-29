package com.microservice.catalogo.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProdudoDto {

    private String produto;
    private String categoria;
    private Double preco;
}
