package com.luiz.hello_spring_boot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.luiz.hello_spring_boot.dto.CreateUserDTO;
import com.luiz.hello_spring_boot.dto.CreateVehicleDTO;
import com.luiz.hello_spring_boot.dto.VehicleSummaryDTO;
import com.luiz.hello_spring_boot.model.User;
import com.luiz.hello_spring_boot.model.Vehicle;
import com.luiz.hello_spring_boot.repository.UserRepository;
import com.luiz.hello_spring_boot.repository.VehicleRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final VehicleRepository vehicleRepository;

  public UserService(UserRepository userRepository, VehicleRepository vehicleRepository) {
    this.userRepository = userRepository;
    this.vehicleRepository = vehicleRepository;
  }

  public List<CreateUserDTO> getAll() {
    List<User> users = this.userRepository.findAll();
    List<CreateUserDTO> usersDTO = users.stream().map(u -> {
      CreateUserDTO userDTO = new CreateUserDTO();
      userDTO.setId(u.getId());
      userDTO.setName(u.getName());
      userDTO.setEmail(u.getEmail());
      userDTO.setVehicles(u.getVehicles().stream().map(v -> {
        VehicleSummaryDTO vehicleSummaryDTO = new VehicleSummaryDTO();
        vehicleSummaryDTO.setId(v.getId());
        vehicleSummaryDTO.setModel(v.getModel());
        vehicleSummaryDTO.setLicensePlate(v.getLicensePlate());
        return vehicleSummaryDTO;
      }).toList());
      return userDTO;
    }).toList();

    return usersDTO;
  }

  public Optional<CreateUserDTO> getById(UUID id) {
    User user = this.userRepository.findById(id).orElseThrow();
    CreateUserDTO userDTO = new CreateUserDTO();
    userDTO.setId(user.getId());
    userDTO.setName(user.getName());
    userDTO.setEmail(user.getEmail());
    userDTO.setVehicles(user.getVehicles().stream().map(v -> {
      VehicleSummaryDTO vehicleSummaryDTO = new VehicleSummaryDTO();
      vehicleSummaryDTO.setId(v.getId());
      vehicleSummaryDTO.setModel(v.getModel());
      vehicleSummaryDTO.setLicensePlate(v.getLicensePlate());
      return vehicleSummaryDTO;
    }).toList());

    return Optional.of(userDTO);
  }

  public User createNew(User user) {
    return this.userRepository.save(user);
  }

  public void deleteById(UUID id) {
    this.userRepository.deleteById(id);
  }

  public void addNewVehicle(UUID userId, CreateVehicleDTO vehicle) {
    Optional<User> user = this.userRepository.findById(userId);

    if (user.isEmpty()) {
      throw new RuntimeException("User not found");
    }

    Vehicle newVehicle = new Vehicle();
    newVehicle.setModel(vehicle.getModel());
    newVehicle.setLicensePlate(vehicle.getLicensePlate());
    newVehicle.setOwner(user.get());

    this.vehicleRepository.save(newVehicle);
  }
}
