//package com.example.demoSpring.model;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.apache.catalina.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class CustomUserDetails extends Users implements UserDetails {
//	
//	public CustomUserDetails(Users users) {
//		super();
//	}
// 
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority>authoritylist = new ArrayList<>();
//		super.getRoles().forEach(role->{
//			authoritylist.add(new SimpleGrantedAuthority(role.getName()));		
//		});
//		return authoritylist;
//		
//	}
//
//	@Override
//	public String getUsername() {
//		return super.getEmail();
//	}
//
//	@Override
//	public String getPassword() {
//		return super.getPassword();
//		}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}
