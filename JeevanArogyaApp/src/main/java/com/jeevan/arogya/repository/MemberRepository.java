package com.jeevan.arogya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeevan.arogya.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	
	@Query("select c.sessionKey from CurrentUserSession c where c.userId=?1")
	public String getSessionKeyByUserId2(Integer userId);
}
