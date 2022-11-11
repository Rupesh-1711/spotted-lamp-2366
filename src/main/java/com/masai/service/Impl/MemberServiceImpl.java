package com.masai.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Member;
import com.masai.repository.MemberDao;
import com.masai.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
  
	@Autowired
	private MemberDao memberdao;
	@Override
	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		return memberdao.save(member);
	}

}
