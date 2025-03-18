package com.luiz.hello_spring_boot.dto;

import java.util.List;
import java.util.UUID;

public class CreateUserDTO {
  private UUID id;
  private String name;
  private String email;
  private List<VehicleSummaryDTO> vehicles;

  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
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
  public List<VehicleSummaryDTO> getVehicles() {
    return vehicles;
  }
  public void setVehicles(List<VehicleSummaryDTO> vehicles) {
    this.vehicles = vehicles;
  }  
}
