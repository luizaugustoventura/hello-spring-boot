package com.luiz.hello_spring_boot.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.hello_spring_boot.dto.CreateUserDTO;
import com.luiz.hello_spring_boot.dto.CreateVehicleDTO;
import com.luiz.hello_spring_boot.model.User;
import com.luiz.hello_spring_boot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/all")
  public List<CreateUserDTO> getAllUsers() {
    return this.userService.getAll();
  }

  @GetMapping("/{userId}")
  public Optional<CreateUserDTO> getUserById(@PathVariable UUID userId) {
    return userService.getById(userId);
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return this.userService.createNew(user);
  }

  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable UUID userId) {
    System.out.println("Deleting user with id: " + userId);
    this.userService.deleteById(userId);
  }

  @PostMapping("/{userId}/vehicles")
  public void addNewVehicle(@PathVariable UUID userId, @RequestBody CreateVehicleDTO vehicle) {
    this.userService.addNewVehicle(userId, vehicle);
  }
}
