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

import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.exception.UserException;
import com.jeevan.arogya.exception.VaccinationCenterException;
import com.jeevan.arogya.implementation.UserServiceImpl;
import com.jeevan.arogya.service.UserService;
import com.jeevan.arogya.service.VaccinationCenterService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public UserService uService;
	
	//Vaccine Center
	@Autowired
	public VaccinationCenterService vinService;
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws UserException{
		
	    User newUser=uService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId) throws UserException{ 
		  
	          User deletedUser = uService.deleteUser(userId);
		
	          return new ResponseEntity<User>(deletedUser,HttpStatus.OK);
	          
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) throws UserException{
		
		User getUser = uService.getUserById(userId);
		
		return new ResponseEntity<User>(getUser,HttpStatus.OK);
	}
	
	@GetMapping("/allusersbyname/{name}")
	public ResponseEntity<List<User>> getUsersByFirstName(@PathVariable("name") String name) throws UserException {
		List<User> users = uService.getUsersByFirstName(name);
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	@GetMapping("/allusers")
	public ResponseEntity<List<User>>  getAllUsers() throws UserException{
		List<User> users = uService.getAllUsers();
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	//VaccinationCenter Starts from here
	

	
	@PostMapping("/createcenter")
	public  ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter center) throws VaccinationCenterException{
		      VaccinationCenter newCenter = vinService.addVaccinationCenter(center);
		      
		      return new ResponseEntity<VaccinationCenter>(newCenter,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allcenter")
	public ResponseEntity<List<VaccinationCenter>>  getallVaccinaCenters() throws UserException, VaccinationCenterException{
		List<VaccinationCenter> users = vinService.getVaccineCenters();
		
		return new ResponseEntity<List<VaccinationCenter>>(users,HttpStatus.OK);
	}
	
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
	
	@PutMapping("/updatecenter")
    public ResponseEntity<VaccinationCenter> updateVaccineCenter(@RequestBody VaccinationCenter center)throws VaccinationCenterException{
	
	VaccinationCenter updatedCenter = vinService.updateVaccineCenter(center);
	
	return new ResponseEntity<VaccinationCenter>(updatedCenter,HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/deletecenter/{code}")
	public ResponseEntity<VaccinationCenter> deleteVaccineCenter(@PathVariable("code") Integer code)throws VaccinationCenterException{
	
		VaccinationCenter deleteCenter = vinService.deleteVaccineCenter(code);
		
		return new ResponseEntity<VaccinationCenter>(deleteCenter,HttpStatus.ACCEPTED);
	}

	
}






















