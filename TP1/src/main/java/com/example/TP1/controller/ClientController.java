
package com.example.TP1.controller;

import com.example.TP1.model.Client;
import com.example.TP1.model.Contract;
import com.example.TP1.service.ClientService;
import com.example.TP1.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    private final ContractService contractService;

    public ClientController(ClientService clientService, ContractService contractService) {
        this.clientService = clientService;
        this.contractService = contractService;
    }

    @GetMapping
    public List<Client> listOfClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client aClient(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @GetMapping("/{id}/contracts")
    public List<Contract> contractsOfClient(@PathVariable("id") Long id) {
        return contractService.findByClient(id);
    }
}