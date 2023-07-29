package com.example.demoSpring.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;

public class UserDto {
	
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	@Email
	private String email;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String role;
}
