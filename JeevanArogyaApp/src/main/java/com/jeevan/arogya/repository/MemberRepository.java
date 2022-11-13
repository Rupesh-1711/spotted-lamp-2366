package com.jeevan.arogya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeevan.arogya.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
