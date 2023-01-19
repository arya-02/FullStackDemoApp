package com.backend.rest.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(long id) {
		super("Could not find user with user id - "+id);
	}
	
}
