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

import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.entity.Vaccine;
import com.jeevan.arogya.entity.VaccineInventory;
import com.jeevan.arogya.exception.UserException;
import com.jeevan.arogya.exception.VaccinationCenterException;
import com.jeevan.arogya.exception.VaccineInventoryException;
import com.jeevan.arogya.exception.VaccineNotFoundException;
import com.jeevan.arogya.service.UserService;
import com.jeevan.arogya.service.VaccinationCenterService;
import com.jeevan.arogya.service.VaccineInventoryService;
import com.jeevan.arogya.service.VaccineService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private VaccinationCenterService vinService;
	
	@Autowired
	private VaccineInventoryService inventoryService;
	
	@Autowired
	private VaccineService vService;

	
	
	
//	User Services
	
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId) throws UserException{ 
		  
	          User deletedUser = uService.deleteUser(userId);
		
	          return new ResponseEntity<User>(deletedUser,HttpStatus.OK);
	          
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) throws UserException{
		
		User getUser = uService.getUserById(userId);
		
		return new ResponseEntity<User>(getUser,HttpStatus.OK);
	}
	
	@GetMapping("/user/name/{name}")
	public ResponseEntity<List<User>> getUsersByFirstName(@PathVariable("name") String name) throws UserException {
		List<User> users = uService.getUsersByFirstName(name);
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>>  getAllUsers() throws UserException{
		List<User> users = uService.getAllUsers();
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	
//	VaccinationCenter Services
	
	@PostMapping("/center")
	public  ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter center) throws VaccinationCenterException{
		      VaccinationCenter newCenter = vinService.addVaccinationCenter(center);
		      
		      return new ResponseEntity<VaccinationCenter>(newCenter,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/centers")
	public ResponseEntity<List<VaccinationCenter>>  getallVaccinaCenters() throws UserException, VaccinationCenterException{
		List<VaccinationCenter> users = vinService.getVaccineCenters();
		
		return new ResponseEntity<List<VaccinationCenter>>(users,HttpStatus.OK);
	}
	
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
	
	@GetMapping("/center/{code}")
	public ResponseEntity<VaccinationCenter> getVaccineCenter(@PathVariable("code") Integer code)throws VaccinationCenterException{
		
	    VaccinationCenter centerbycode = vinService.getVaccineCenter(code);
	    
	    return new ResponseEntity<VaccinationCenter>(centerbycode,HttpStatus.OK);
	}
	
	@PutMapping("/center")
    public ResponseEntity<VaccinationCenter> updateVaccineCenter(@RequestBody VaccinationCenter center)throws VaccinationCenterException{
	
	VaccinationCenter updatedCenter = vinService.updateVaccineCenter(center);
	
	return new ResponseEntity<VaccinationCenter>(updatedCenter,HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/center/{code}")
	public ResponseEntity<VaccinationCenter> deleteVaccineCenter(@PathVariable("code") Integer code)throws VaccinationCenterException{
	
		VaccinationCenter deleteCenter = vinService.deleteVaccineCenter(code);
		
		return new ResponseEntity<VaccinationCenter>(deleteCenter,HttpStatus.ACCEPTED);
	}
	
	
//	Inventory Services
	
	@PostMapping("/inventory/center/{id}")
	public ResponseEntity<VaccineInventory> addVaccineInventory(@PathVariable("id")Integer id,@RequestBody VaccineInventory inventory) throws VaccineInventoryException{
		
		VaccineInventory savedInventory=inventoryService.addVaccineInventory(inventory,id);
		
		return new ResponseEntity<VaccineInventory>(savedInventory, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/inventory/{id}")
	public ResponseEntity<VaccineInventory> getVaccineInventroyById(@PathVariable("id") Integer id) throws VaccineInventoryException{
		
		VaccineInventory inventory=inventoryService.getVaccineInventoryById(id);
		
		return new ResponseEntity<VaccineInventory>(inventory, HttpStatus.OK);
	}

	@PutMapping("/inventory")
	public ResponseEntity<VaccineInventory> updateVaccineInventory(@RequestBody VaccineInventory inventory) throws VaccineInventoryException{
	
	VaccineInventory newInventory=inventoryService.updateVaccineInventory(inventory);
	
	return new ResponseEntity<VaccineInventory>(newInventory, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/inventory/{id}")
	public ResponseEntity<VaccineInventory> deleteVaccineInventroyById(@PathVariable("id") Integer id) throws VaccineInventoryException{
	
	VaccineInventory deletedInventory=inventoryService.deleteVaccineInventory(id);
	
	return new ResponseEntity<VaccineInventory>(deletedInventory, HttpStatus.ACCEPTED);
	}

	
//	Vaccine Service
	
	@PostMapping("/vaccine/inventory/{id}")
	public ResponseEntity<Vaccine> addVaccine(@PathVariable("id") Integer id,@RequestBody Vaccine vaccine) throws VaccineNotFoundException {
	       
		return new ResponseEntity<Vaccine>(vService.addVaccine(vaccine,id), HttpStatus.ACCEPTED);
	
	}
	
	@GetMapping("/vaccines")
    public ResponseEntity<List<Vaccine>> getAllVaccines() throws VaccineNotFoundException {
		
        return new ResponseEntity<List<Vaccine>>(vService.allVaccine(), HttpStatus.FOUND);
    
	}
	
	@PutMapping("/vaccine")
    public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine vaccine) throws VaccineNotFoundException {
		
        return new ResponseEntity<Vaccine>(vService.updateVaccine(vaccine), HttpStatus.OK);
    
	}
	
	@DeleteMapping("/vaccine{id}")
    public ResponseEntity<String> deleteVaccine(@PathVariable("id")Integer id) throws VaccineNotFoundException {
		
        return new ResponseEntity<String>("Vaccine deleted : " + vService.deleteVaccine(id), HttpStatus.OK);
    
	}

	

}






















