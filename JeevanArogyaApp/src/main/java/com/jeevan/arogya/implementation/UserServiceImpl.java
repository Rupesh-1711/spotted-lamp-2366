package com.jeevan.arogya.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.exception.UserException;
import com.jeevan.arogya.repository.UserRepository;
import com.jeevan.arogya.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserRepository uRepo;
	
	@Override
	public User createUser(User user) throws UserException {

		User newUser=uRepo.findByMobile(user.getMobile());
		if(newUser == null) {
			uRepo.save(user);
			return user;
		}else {
			throw new UserException("User has been already Registered with this Mobile Number:"+user.getMobile());
		}
		
	}

	@Override
	public User deleteUser(Integer userId) throws UserException {
		Optional<User> opt = uRepo.findById(userId);
		
		if(opt.isEmpty()) {
			throw new UserException("User Nont found with Id"+userId);
		}else {
			User exisingUser = opt.get();			
			uRepo.delete(exisingUser);
			return exisingUser;
		}
	}

	@Override
	public User getUserById(Integer userId) throws UserException {
		Optional<User> opt = uRepo.findById(userId);
		
		if(opt.isEmpty()) {
			throw new UserException("User Nont found with Id"+userId);
		}else {
			
			User result = opt.get();
			return result;
		}
	}

	@Override
	public List<User> getUsersByFirstName(String name) throws UserException {
		 List<User> users = uRepo.findUsersByFirstName(name);
			
			if(users.size()!=0) {
				return users;
			}else {
				throw new UserException("User not found with name "+name);
			}
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		 List<User> users = uRepo.findAll();
			
			if(users.size()!=0) {
				return users;
			}else {
				throw new UserException("User not found ......");
			}
	}

}
