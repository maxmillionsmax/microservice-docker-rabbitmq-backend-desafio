package com.microservice.loja.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

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
