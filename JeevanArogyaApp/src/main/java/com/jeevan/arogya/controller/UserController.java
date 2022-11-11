package com.jeevan.arogya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeevan.arogya.entity.LoginDTO;
import com.jeevan.arogya.exception.LoginException;
import com.jeevan.arogya.service.LoginService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private LoginService userLogin;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogIn(@RequestBody LoginDTO dto) throws LoginException{
		String loginResponse=userLogin.logIntoAccount(dto);
		
		return new ResponseEntity<String>(loginResponse, HttpStatus.OK);
	}
	
	@PostMapping("/logout/{key}")
	public ResponseEntity<String> userLogOut(@PathVariable("key") String key) throws LoginException{
		String loginResponse=userLogin.logOutAccount(key);
		
		return new ResponseEntity<String>(loginResponse, HttpStatus.OK);
	}
}
