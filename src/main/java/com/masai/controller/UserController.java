package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Member;
import com.masai.service.MemberService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping(value = "/user")
	public Member addMember(@RequestBody Member member) {
		Member createdMember = memberService.addMember(member);
		return createdMember;
	}
	

}
