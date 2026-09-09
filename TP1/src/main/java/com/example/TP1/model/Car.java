
package com.example.TP1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {

    @Id
    private String plateNumber;
    private String brand;
    private double price;

    private boolean rented;

    public Car() {
    }

    public Car(String plateNumber, String brand, double price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}