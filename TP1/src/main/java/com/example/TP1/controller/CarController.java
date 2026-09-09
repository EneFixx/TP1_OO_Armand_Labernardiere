
package com.example.TP1.controller;

import com.example.TP1.model.Car;
import com.example.TP1.model.Dates;
import com.example.TP1.service.CarService;
import com.example.TP1.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;
    private final ContractService contractService;

    public CarController(CarService carService, ContractService contractService) {
        this.carService = carService;
        this.contractService = contractService;
    }

    @GetMapping("/cars")
    public List<Car> listOfCars(@RequestParam(value = "all", defaultValue = "false") boolean all) {
        return all ? carService.findAll() : carService.findAvailable();
    }

    @GetMapping("/cars/{plateNumber}")
    public Car aCar(@PathVariable("plateNumber") String plateNumber) {
        return carService.findByPlateNumber(plateNumber);
    }

    @PutMapping("/cars/{plateNumber}")
    public void rentOrGetBack(@PathVariable("plateNumber") String plateNumber,
                              @RequestParam("rent") boolean rent,
                              @RequestParam(value = "clientId", required = false) Long clientId,
                              @RequestBody(required = false) Dates dates) {
        if (rent) {
            contractService.rent(plateNumber, clientId, dates);
        } else {
            contractService.getBack(plateNumber);
        }
    }
}