package com.jeevan.arogya.implementation;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.Member;
import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.exception.UserException;
import com.jeevan.arogya.repository.MemberRepository;
import com.jeevan.arogya.repository.SessionRepository;
import com.jeevan.arogya.repository.UserRepository;
import com.jeevan.arogya.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository mRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private SessionRepository sRepo;
	
	@Override
	public Member addMember(Member member,Integer userId) throws UserException {
		 String sessionKey=sRepo.getSessionKeyByUserId(userId);
		 if(sessionKey==null)
			 throw new UserException("User with this id is not logged-in:");
		 
		 Optional<User>opt=uRepo.findById(userId);
		 User user=opt.get();
		 
		 member.setUser(user);
		 
		 return mRepo.save(member);
	}
	
}



















