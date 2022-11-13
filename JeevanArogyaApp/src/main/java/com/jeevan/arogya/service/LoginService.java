package com.jeevan.arogya.service;


import com.jeevan.arogya.entity.LoginDTO;
import com.jeevan.arogya.exception.LoginException;


public interface LoginService {

	public String logIntoAccount(LoginDTO dto) throws LoginException;
	
	public String logOutAccount(String sessionKey) throws LoginException;
}
