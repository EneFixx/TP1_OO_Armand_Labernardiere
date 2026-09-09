package com.example.TP1.repository;

import com.example.TP1.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    List<Car> findByRentedFalse();
}