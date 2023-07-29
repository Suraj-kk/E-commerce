//package com.example.demoSpring.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.example.demoSpring.model.CustomUserDetails;
//import com.example.demoSpring.model.Users;
//import com.example.demoSpring.repo.UserRepo;
//
//public class UserInfoUserDetailsService implements UserDetailsService {
//	 @Autowired
//	    private UserRepo userRepo;
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		   Optional<Users> user = userRepo.findByEmail(email);
//	        if (user == null) {
//	            throw new UsernameNotFoundException("User not found");
//	        }
//	        return new CustomUserDetails(user);
//	}
//
//}
