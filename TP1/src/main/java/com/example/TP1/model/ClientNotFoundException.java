// src/main/java/com/example/TP1/model/ClientNotFoundException.java
package com.example.TP1.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super("Aucun client avec l'id " + id);
    }
}