package com.jeevan.arogya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeevan.arogya.entity.CurrentUserSession;

@Repository
public interface SessionRepository extends JpaRepository<CurrentUserSession, Integer> {

	public CurrentUserSession findBySessionKey(String sessionKey);
}
