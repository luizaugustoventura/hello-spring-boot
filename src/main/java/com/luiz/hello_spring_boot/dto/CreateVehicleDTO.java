package com.luiz.hello_spring_boot.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateVehicleDTO {
  private UUID id;
  private String model;
  @JsonProperty(value = "license_plate")
  private String licensePlate;

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
}
