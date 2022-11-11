package com.jeevan.arogya.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.exception.UserException;
import com.jeevan.arogya.implementation.UserServiceImpl;
import com.jeevan.arogya.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public UserService uService;
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws UserException{
		
	    User newUser=uService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId) throws UserException{ 
		  
	          User deletedUser = uService.deleteUser(userId);
		
	          return new ResponseEntity<User>(deletedUser,HttpStatus.OK);
	          
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) throws UserException{
		
		User getUser = uService.getUserById(userId);
		
		return new ResponseEntity<User>(getUser,HttpStatus.OK);
	}
	
	@GetMapping("/allusersbyname/{name}")
	public ResponseEntity<List<User>> getUsersByFirstName(@PathVariable("name") String name) throws UserException {
		List<User> users = uService.getUsersByFirstName(name);
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	@GetMapping("/allusers")
	public ResponseEntity<List<User>>  getAllUsers() throws UserException{
		List<User> users = uService.getAllUsers();
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
}






















