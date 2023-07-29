package com.example.demoSpring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoSpring.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{
	Users findByEmail(String email);
}
