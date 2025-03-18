package com.luiz.hello_spring_boot.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
  @Id()
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;
  private String email;

  @JsonManagedReference
  @OneToMany(targetEntity = Vehicle.class, mappedBy = "owner")
  private List<Vehicle> vehicles;

  public User() {}

  public User(String name, String email, List<Vehicle> vehicles) {
    this.name = name;
    this.email = email;
    this.vehicles = vehicles;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<Vehicle> getVehicles() {
    return vehicles;
  }

  public void setVehicles(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }
}