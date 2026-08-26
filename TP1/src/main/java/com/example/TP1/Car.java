package com.example.TP1;

public class Car {
    private String plateNumber;
    private String brand;
    private double price;
    private Dates rentalDates;


    public Car(String plateNumber, String brand, double price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
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

    public Dates getRentalDates() {
        return rentalDates;
    }

    public void setRentalDates(Dates rentalDates) {
        this.rentalDates = rentalDates;
    }

    public boolean isRented() {
        return rentalDates != null;
    }
}