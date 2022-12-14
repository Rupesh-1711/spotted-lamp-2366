package com.jeevan.arogya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeevan.arogya.entity.CurrentUserSession;

@Repository
public interface SessionRepository extends JpaRepository<CurrentUserSession, Integer> {

	public CurrentUserSession findBySessionKey(String sessionKey);
	
	@Query("select c.sessionKey from CurrentUserSession c where c.userId=?1")
	public String getSessionKeyByUserId(Integer userId);
	
	@Query("select u.userId from CurrentUserSession u")
	public Integer getUserId();
	
}
