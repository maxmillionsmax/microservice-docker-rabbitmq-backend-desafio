package com.microservice.loja.controller;

import com.microservice.loja.dto.ClientDto;
import com.microservice.loja.entity.Client;
import com.microservice.loja.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody ClientDto clientDto) {

        try {
            return ResponseEntity.ok(clientService.insertClient(Client.create(clientDto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientDto){

        Client client = Client.create(clientDto);
        client.setId(id);
        Client updateClient =  clientService.updateClient(client);
        return Objects.nonNull(updateClient) ?
                ResponseEntity.ok(updateClient) :
                ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id){

        return clientService.deleteClient(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
    @GetMapping("/find/")
    public List<Client> findAll(){
        return clientService.findAll();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){

        Optional<Client> client =  clientService.findById(id);
        return client.isPresent() ?
                ResponseEntity.ok(client.get()) :
                ResponseEntity.notFound().build();
    }
}

