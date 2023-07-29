package com.example.demoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demoSpring.model.Users;
import com.example.demoSpring.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminRegController {
	@Autowired
	UserService userservice;
	

	@GetMapping("/Adminlogin")
	public String signupPage() {
		return "Adminlogin";
	}

	@PostMapping("/Adminlogin")
	 public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		if (userservice.AdminLogin(email,password)) {
			return "AdminHome";
		}
		else {
//		System.out.println("invalid username or password");
		 return "redirect:/Adminlogin?error";
		}
	 }
	

}
