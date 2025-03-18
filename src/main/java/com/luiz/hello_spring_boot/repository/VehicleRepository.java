package com.luiz.hello_spring_boot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luiz.hello_spring_boot.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {}
