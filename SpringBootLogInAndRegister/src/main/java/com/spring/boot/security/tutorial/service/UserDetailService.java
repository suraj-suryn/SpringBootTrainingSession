package com.spring.boot.security.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.boot.security.tutorial.model.User;
import com.spring.boot.security.tutorial.model.UserPrincipal;
import com.spring.boot.security.tutorial.repository.UserRepository;

public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not found!");
		}
		return new UserPrincipal(user) ;
		
	}

}
