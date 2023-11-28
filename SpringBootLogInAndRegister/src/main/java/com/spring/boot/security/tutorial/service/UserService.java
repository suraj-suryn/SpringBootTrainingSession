package com.spring.boot.security.tutorial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.security.tutorial.model.User;

@Service
public class UserService {

	List<User> users = new ArrayList<>();

	public UserService() {
		users.add(new User("U1", "Sam", "Sam", "ADMIN", "sam@gmail.com"));
		users.add(new User("U2", "Jack", "Jack", "ADMIN", "jack@gmail.com"));
		users.add(new User("U3", "Roy", "Roy", "NORMAL", "roy@gmail.com"));
		users.add(new User("U4", "Mack", "Mack", "NORMAL", "mack@gmail.com"));

	}

	public List<User> getALlUser() {
		return this.users;
	}

	public User getUser(String username) {
		return this.users.stream().filter((user) -> user.getUsername().equalsIgnoreCase(username)).findAny().orElse(null);
	}

	public User addUser(User user) {
		this.users.add(user);
		return user;
	}

}
