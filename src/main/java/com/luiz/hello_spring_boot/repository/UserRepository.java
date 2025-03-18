package com.luiz.hello_spring_boot.repository;

import com.luiz.hello_spring_boot.model.User;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {}