
package com.example.TP1.service;

import com.example.TP1.model.*;
import com.example.TP1.repository.ContractRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final CarService carService;
    private final ClientService clientService;

    public ContractService(ContractRepository contractRepository,
                           CarService carService,
                           ClientService clientService) {
        this.contractRepository = contractRepository;
        this.carService = carService;
        this.clientService = clientService;
    }

    @Transactional
    public Contract rent(String plateNumber, Long clientId, Dates dates) {
        Car car = carService.findByPlateNumber(plateNumber);
        Client client = clientService.findById(clientId);

        if (car.isRented()) {
            throw new CarStateException("La voiture " + plateNumber + " est déjà louée");
        }

        car.setRented(true);
        carService.save(car);

        return contractRepository.save(new Contract(client, car, dates));
    }

    @Transactional
    public void getBack(String plateNumber) {
        Car car = carService.findByPlateNumber(plateNumber);

        Contract contract = contractRepository.findByCarPlateNumberAndActiveTrue(plateNumber)
                .orElseThrow(() -> new CarStateException(
                        "La voiture " + plateNumber + " n'est pas louée"));

        contract.setActive(false);
        contractRepository.save(contract);

        car.setRented(false);
        carService.save(car);
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public List<Contract> findActive() {
        return contractRepository.findByActiveTrue();
    }

    public List<Contract> findByClient(Long clientId) {
        clientService.findById(clientId);
        return contractRepository.findByClientId(clientId);
    }
}