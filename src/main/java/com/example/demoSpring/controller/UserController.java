package com.example.demoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoSpring.model.Users;
import com.example.demoSpring.service.UserService;

@Controller

public class UserController {
	@Autowired
	UserService userservice;

	@PostMapping("/register")
	public String signupPage(Users user) {
		userservice.adduser(user);
		return "shop";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		if (userservice.UserLogin(email, password)) {
			return "shop";
		} else {
			System.out.println("invalid username or password");
			return "redirect:/login?error";
		}
	}

	@GetMapping("/logout")
	public String logout() {
		return "/index";
	}

}
