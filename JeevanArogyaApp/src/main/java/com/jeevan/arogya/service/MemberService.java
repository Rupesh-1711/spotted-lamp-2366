package com.jeevan.arogya.service;

import com.jeevan.arogya.entity.Member;
import com.jeevan.arogya.exception.UserException;

public interface MemberService {

	public Member addMember(Member member) throws UserException;

}
