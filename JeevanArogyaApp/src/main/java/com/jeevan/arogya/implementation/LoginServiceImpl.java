package com.jeevan.arogya.implementation;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.CurrentUserSession;
import com.jeevan.arogya.entity.LoginDTO;
import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.exception.LoginException;
import com.jeevan.arogya.repository.SessionRepository;
import com.jeevan.arogya.repository.UserRepository;
import com.jeevan.arogya.service.LoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private SessionRepository sRepo;
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		
		User existingUser=uRepo.findByMobile(dto.getMobile());
		if(existingUser==null)
			throw new LoginException("Account Not Found with Mobile No: "+dto.getMobile());
		
		Optional<CurrentUserSession> currentSessionOpt=sRepo.findById(existingUser.getUserId());
		
		if(currentSessionOpt.isPresent())
			throw new LoginException("User is already Logged in:");
		
		if(existingUser.getPassword().equals(dto.getPassword())) {
			
			String sessionKey= RandomString.make(8);
			
			CurrentUserSession currentUserSession=new CurrentUserSession(existingUser.getUserId(), sessionKey, LocalDateTime.now());
			
			sRepo.save(currentUserSession);
			
			return currentUserSession.getSessionKey();
		}
		else {
			throw new LoginException("Please Enter a valid password");
		}
			
		
	}

	@Override
	public String logOutAccount(String sessionKey) throws LoginException {
		
		CurrentUserSession currentUserSession=sRepo.findBySessionKey(sessionKey);
		
		if(currentUserSession==null)
			throw new LoginException("Not a valid session key/ Not logged in with this key");
		
		sRepo.delete(currentUserSession);
		
		return "Logged Out..";
		
	}

}
