package com.microservice.loja.service;

import com.microservice.loja.dto.ClientOrderDto;
import com.microservice.loja.entity.Client;
import com.microservice.loja.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }


    public Client insertClient(Client client){
        Client newClient = clientRepository.save(client);
         return newClient;
    }

    public Client updateClient(Client client){

        Optional<Client> newClient = clientRepository.findById(client.getId());

        if (newClient.isPresent()){
            return clientRepository.save(client);
        }else {
            return null;
        }
    }
    public boolean deleteClient(Long id){

        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()){
            clientRepository.delete(client.get());
            return true;
        }else {
            return false;
        }
    }
    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
