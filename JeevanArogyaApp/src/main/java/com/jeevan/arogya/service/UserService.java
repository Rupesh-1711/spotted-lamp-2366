package com.jeevan.arogya.service;

import java.util.List;

import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.exception.UserException;

public interface UserService {

	public User createUser(User user) throws UserException;
	
	public User deleteUser(Integer userId) throws UserException ;

	public User getUserById(Integer userId) throws UserException;
	
	public List<User> getUsersByFirstName(String name) throws UserException;
	
	public List<User> getAllUsers() throws UserException;

}
