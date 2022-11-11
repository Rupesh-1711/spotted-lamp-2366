package com.jeevan.arogya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeevan.arogya.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByMobile(String string); 
	
	public User findByAadharNo(String aadharNo);
	
	public List<User> findUsersByFirstName(String firstName);
	
}
