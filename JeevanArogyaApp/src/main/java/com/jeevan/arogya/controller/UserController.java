package com.jeevan.arogya.controller;

import java.util.List;

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

import com.jeevan.arogya.entity.LoginDTO;
import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.exception.LoginException;
import com.jeevan.arogya.exception.UserException;
import com.jeevan.arogya.exception.VaccinationCenterException;
import com.jeevan.arogya.service.LoginService;
import com.jeevan.arogya.service.VaccinationCenterService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private LoginService userLogin;
	
	@Autowired
	public VaccinationCenterService vinService;
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogIn(@RequestBody LoginDTO dto) throws LoginException{
		String loginResponse=userLogin.logIntoAccount(dto);
		
		return new ResponseEntity<String>(loginResponse, HttpStatus.OK);
	}
	
	@PostMapping("/logout/{key}")
	public ResponseEntity<String> userLogOut(@PathVariable("key") String key) throws LoginException{
		String loginResponse=userLogin.logOutAccount(key);
		
		return new ResponseEntity<String>(loginResponse, HttpStatus.OK);
	}
	
	// Vaccin center
	


	
	@GetMapping("/centerbystate/{state}")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByState(@PathVariable("state") String state) throws VaccinationCenterException{
		
		List<VaccinationCenter> centers = vinService.getVaccineCenterByState(state);
		
		return new ResponseEntity<List<VaccinationCenter>>(centers,HttpStatus.OK);
	}
	
	@GetMapping("/centerbycity/{city}")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByCity(@PathVariable("city") String city) throws VaccinationCenterException{
		
		List<VaccinationCenter> centers = vinService.getVaccineCenterByCity(city);
		
		return new ResponseEntity<List<VaccinationCenter>>(centers,HttpStatus.OK);
	}
	@GetMapping("/centerbypincode/{pincode}")
	public ResponseEntity<List<VaccinationCenter>> getVaccineCenterByPncode(@PathVariable("pincode") String pincode) throws VaccinationCenterException{
		
		List<VaccinationCenter> centers = vinService.getVaccineCenterByState(pincode);
		
		return new ResponseEntity<List<VaccinationCenter>>(centers,HttpStatus.OK);
	}
	
	@GetMapping("/centerbycode/{code}")
	public ResponseEntity<VaccinationCenter> getVaccineCenter(@PathVariable("code") Integer code)throws VaccinationCenterException{
		
	    VaccinationCenter centerbycode = vinService.getVaccineCenter(code);
	    
	    return new ResponseEntity<VaccinationCenter>(centerbycode,HttpStatus.OK);
	}
	

	

}
