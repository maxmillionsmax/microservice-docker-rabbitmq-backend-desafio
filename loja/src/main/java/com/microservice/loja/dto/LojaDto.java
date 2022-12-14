package com.microservice.loja.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LojaDto {

    private String nome;
    private String endereco;
    private String cnpj;
}
