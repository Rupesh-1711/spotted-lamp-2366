package com.jeevan.arogya.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeevan.arogya.entity.Appointment;
import com.jeevan.arogya.entity.LoginDTO;
import com.jeevan.arogya.entity.Member;
import com.jeevan.arogya.entity.StatusDTO;
import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.exception.AppointmentException;
import com.jeevan.arogya.exception.LoginException;
import com.jeevan.arogya.exception.UserException;
import com.jeevan.arogya.exception.VaccinationCenterException;
import com.jeevan.arogya.service.AppointmentService;
import com.jeevan.arogya.service.LoginService;
import com.jeevan.arogya.service.MemberService;
import com.jeevan.arogya.service.UserService;
import com.jeevan.arogya.service.VaccinationCenterService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private LoginService userLogin;
	
	@Autowired
	private VaccinationCenterService vinService;
	
	@Autowired
	private  MemberService mService;
	
	@Autowired
	private AppointmentService aService;
	
	
	
//  User
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws UserException{
		
	    User newUser=uService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
//	login-logout

	@PostMapping("/login")
	public ResponseEntity<String> userLogIn(@RequestBody LoginDTO dto) throws LoginException {
		String loginResponse=userLogin.logIntoAccount(dto);
		
		return new ResponseEntity<String>(loginResponse, HttpStatus.OK);
	}
	
	@PostMapping("/logout/{key}")
	public ResponseEntity<String> userLogOut(@PathVariable("key") String key) throws LoginException{
		String loginResponse=userLogin.logOutAccount(key);
		
		return new ResponseEntity<String>(loginResponse, HttpStatus.OK);
	}
	
//	Center
	
	@GetMapping("/center/state/{state}")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByState(@PathVariable("state") String state) throws VaccinationCenterException{
		
		List<VaccinationCenter> centers = vinService.getVaccineCenterByState(state);
		
		return new ResponseEntity<List<VaccinationCenter>>(centers,HttpStatus.OK);
	}
	
	@GetMapping("/center/city/{city}")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByCity(@PathVariable("city") String city) throws VaccinationCenterException{
		
		List<VaccinationCenter> centers = vinService.getVaccineCenterByCity(city);
		
		return new ResponseEntity<List<VaccinationCenter>>(centers,HttpStatus.OK);
	}
	
	@GetMapping("/center/pincode/{pincode}")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByPncode(@PathVariable("pincode") String pincode) throws VaccinationCenterException{
		
		List<VaccinationCenter> centers = vinService.getVaccineCenterByState(pincode);
		
		return new ResponseEntity<List<VaccinationCenter>>(centers,HttpStatus.OK);
	}
	
	
// Member 
	
	@PostMapping("/{userId}/member")
	public ResponseEntity<Member> createMember(@PathVariable("userId") Integer userId,@RequestBody Member member) throws UserException{
		
		      Member addedMember = mService.addMember(member, userId);
		
		return new ResponseEntity<Member>(addedMember,HttpStatus.CREATED);
	}
	
	
// Appointment
	@PostMapping("/appointment/member/{memberId}")
	public ResponseEntity<Appointment> createAppointment(@PathVariable("memberId")Integer memberId,@RequestBody Appointment appointment) throws AppointmentException{
		
		Appointment bookedAppointment=aService.bookAppointment(appointment, memberId);
		
		return new ResponseEntity<Appointment>(bookedAppointment, HttpStatus.CREATED);
	}
	
	@PutMapping("/appointment")
	public ResponseEntity<Appointment> updateAppointement(@RequestBody Appointment appointment) throws AppointmentException{
		
		Appointment updatedAppointment=aService.updateAppointment(appointment);
		
		return new ResponseEntity<Appointment>(updatedAppointment,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/appointment/{id}")
	public ResponseEntity<Appointment> deleteAppointement(@PathVariable("id") Integer id) throws AppointmentException{
		
		Appointment deletedAppointment=aService.deleteAppointment(id);
		
		return new ResponseEntity<Appointment>(deletedAppointment,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/appointment/{id}")
	public ResponseEntity<StatusDTO> getStatus(@PathVariable("id") Integer id) throws AppointmentException{
		
		StatusDTO status=aService.appointmentStatus(id);
		
		return new ResponseEntity<StatusDTO>(status,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
