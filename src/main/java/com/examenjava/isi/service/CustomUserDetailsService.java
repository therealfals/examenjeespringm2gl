package com.examenjava.isi.service;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examenjava.isi.model.User;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		if (email.trim().isEmpty()) {
			throw new UsernameNotFoundException("L'email est vide");
		}

		User user = userService.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("L'email " + email + " n'existe pas");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),null);
	}

	 

}