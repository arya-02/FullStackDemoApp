package com.backend.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.backend.rest.exception.UserNotFoundException;
import com.backend.rest.model.User;
import com.backend.rest.repository.UserRepo;

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User addNew(User newUser) {
		return userRepo.save(newUser);
	}
	
	public User getUser(long id) {
		return userRepo.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
	}
	
	public User editUser(User newUser,long id) {
		User user = userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
		user.setEmail(newUser.getEmail());
		user.setName(newUser.getName());
		user.setUserName(newUser.getUserName());
		return userRepo.save(user);
	}
	
	public void deleteUser(long id) {
		userRepo.deleteById(id);
		return;
	}
	
}
