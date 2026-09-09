
package com.example.TP1.service;

import com.example.TP1.model.Car;
import com.example.TP1.model.CarNotFoundException;
import com.example.TP1.repository.CarRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostConstruct
    public void init() {
        if (carRepository.count() > 0) {
            return;
        }
        carRepository.save(new Car("11AA22", "Ferrari", 100));
        carRepository.save(new Car("AA11BB", "Renault", 35));
        carRepository.save(new Car("33CC44", "Porsche", 120));
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public List<Car> findAvailable() {
        return carRepository.findByRentedFalse();
    }

    public Car findByPlateNumber(String plateNumber) {
        return carRepository.findById(plateNumber)
                .orElseThrow(() -> new CarNotFoundException(plateNumber));
    }

    public void save(Car car) {
        carRepository.save(car);
    }
}