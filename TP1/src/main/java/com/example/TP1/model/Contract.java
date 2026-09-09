// src/main/java/com/example/TP1/model/Contract.java
package com.example.TP1.model;

import jakarta.persistence.*;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_plate_number")
    private Car car;

    @Embedded
    private Dates dates;

    private boolean active;

    public Contract() {
    }

    public Contract(Client client, Car car, Dates dates) {
        this.client = client;
        this.car = car;
        this.dates = dates;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public Dates getDates() {
        return dates;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}