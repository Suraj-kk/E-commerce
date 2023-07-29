package com.example.demoSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demoSpring.model.Users;
import com.example.demoSpring.repo.UserRepo;

@Service
@Component
public class UserService {
	@Autowired
	UserRepo userrepo;
//	@Autowired
//	Users user;

	public void adduser(Users user) {
		user.setRole("User");
		userrepo.save(user);
	}

//	public void addAdmin(Users user) {
//		user.setRole("Admin");
//		userrepo.save(user);
//
//	}

	public boolean AdminLogin(String email, String password) {
		Users user = userrepo.findByEmail(email);

		if (user != null && user.getPassword().equals(password) && user.getRole().equals("Admin")) {

			return true;
		} else {

			return false;
		}

	}

	public boolean UserLogin(String email, String password) {
		Users user = userrepo.findByEmail(email);

		if (user != null && user.getPassword().equals(password)) {

			return true;
		} else {

			return false;
		}
	}



}
