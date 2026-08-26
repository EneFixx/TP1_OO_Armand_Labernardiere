package com.example.TP1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String plateNumber) {
        super("Aucune voiture avec la plaque " + plateNumber);
    }
}