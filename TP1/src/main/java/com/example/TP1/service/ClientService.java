
package com.example.TP1.service;

import com.example.TP1.model.Client;
import com.example.TP1.model.ClientNotFoundException;
import com.example.TP1.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostConstruct
    public void init() {
        if (clientRepository.count() > 0) {
            return;
        }
        clientRepository.save(new Client("Armand", "Labernardiere", "armand@example.com"));
        clientRepository.save(new Client("Jean", "Dupont", "jean@example.com"));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }
}