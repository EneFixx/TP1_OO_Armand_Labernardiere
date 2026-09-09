package com.example.TP1.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CarStateException extends RuntimeException {

  public CarStateException(String message) {
    super(message);
  }
}