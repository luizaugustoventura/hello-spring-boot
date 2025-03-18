package com.luiz.hello_spring_boot.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleResponseDTO {
  private UUID id;
  private String model;
  @JsonProperty(value = "license_plate")
  private String licensePlate;
  private CreateUserDTO owner;
  
  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
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
  public CreateUserDTO getOwner() {
    return owner;
  }
  public void setOwner(CreateUserDTO owner) {
    this.owner = owner;
  }
}
