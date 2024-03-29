package com.backend.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.rest.model.User;
import com.backend.rest.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService ser;
	
	@GetMapping("/users")
	List<User> getUsers(){
		List<User> user;
		user = ser.getAllUsers();
		return user;
	}
	
	@PostMapping("/adduser")
	User newUser(@RequestBody User newUser) {
		User u1 = ser.addNew(newUser);
		return u1;
	}
	
	@GetMapping("/user/{id}")
	User getUserById(@PathVariable Long id) {
		User u = ser.getUser(id);
		return u;
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser,@PathVariable long id) {
		User u = ser.editUser(newUser, id);
		return u;
	}
	
	@DeleteMapping("/user/{id}")
	void delete(@PathVariable long id) {
		ser.deleteUser(id);
		return;
	}
	
}
