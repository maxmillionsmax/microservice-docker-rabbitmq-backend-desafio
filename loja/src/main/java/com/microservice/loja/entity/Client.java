package com.microservice.loja.entity;

import com.microservice.loja.dto.ClientDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String endereco;
    private String cpf;

    public static Client create(ClientDto clientDto){
        return new ModelMapper().map(clientDto, Client.class);
    }

}
