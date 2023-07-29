//package com.example.demoSpring.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//@Configuration
//@EnableWebSecurity
//public class SecurityCofig {
//	
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//				.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/","/index","/shop","/register","/login").permitAll()
//		
//				.requestMatchers("/admin","/admin/**").hasRole("ADMIN")
//				.anyRequest().authenticated())
//				.formLogin()
//				.loginPage("Adminlogin")
//				.failureUrl("/login?error = true")
//				.defaultSuccessUrl("/AdminHome")
//				.usernameParameter("email")
//				.passwordParameter("password")
//				.and()
//				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
//		return http.build();
//
//	}
//
//}
