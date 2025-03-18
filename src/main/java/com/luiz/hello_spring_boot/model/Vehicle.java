package com.luiz.hello_spring_boot.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {
  @Id()
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String model;

  @Column(name = "license_plate")
  private String licensePlate;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User owner;
  
  public Vehicle() {}

  public Vehicle(UUID id, String model, String licensePlate, User owner) {
    this.id = id;
    this.model = model;
    this.licensePlate = licensePlate;
    this.owner = owner;
  }

  public UUID getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }
}
