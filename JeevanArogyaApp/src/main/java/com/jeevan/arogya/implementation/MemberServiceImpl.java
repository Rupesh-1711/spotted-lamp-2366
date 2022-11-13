package com.jeevan.arogya.implementation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	private MemberRepository mRpo;
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private SessionRepository sRepo;
	
	@Override
	public Member addMember(Member member) throws UserException {
		
//		User userInfo = uRepo.findByMobile(member.getMobile());
//		String sessionKey = sRepo.getSessionKeyByUserId(userInfo.getUserId());
		Integer userid  = sRepo.getUserId();

		 Optional<User> user1 = uRepo.findById(userid);
		 if(user1.isPresent()) {
			User user2 =  user1.get();
			user2.getMembers().add(member);
			 uRepo.save(user2);
			 
		 }
	
		return null;
		 
	}

}
