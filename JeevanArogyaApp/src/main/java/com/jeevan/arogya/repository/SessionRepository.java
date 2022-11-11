package com.jeevan.arogya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeevan.arogya.entity.CurrentUserSession;

public interface SessionRepository extends JpaRepository<CurrentUserSession, Integer> {

	public CurrentUserSession findBySessionKey(String sessionKey);
}
