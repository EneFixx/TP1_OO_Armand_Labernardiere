// src/main/java/com/example/TP1/controller/ContractController.java
package com.example.TP1.controller;

import com.example.TP1.model.Contract;
import com.example.TP1.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public List<Contract> listOfContracts(
            @RequestParam(value = "active", defaultValue = "false") boolean activeOnly) {
        return activeOnly ? contractService.findActive() : contractService.findAll();
    }
}