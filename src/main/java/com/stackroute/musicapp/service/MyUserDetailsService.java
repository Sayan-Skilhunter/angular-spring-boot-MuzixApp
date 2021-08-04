package com.stackroute.musicapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stackroute.musicapp.model.CustomUserDetails;
import com.stackroute.musicapp.model.User;
import com.stackroute.musicapp.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		Optional<User> user = ur.findByEmail(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Bad Credentials"));
		return new CustomUserDetails(user.get());
	}

}
