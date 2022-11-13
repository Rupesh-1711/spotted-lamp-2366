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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeevan.arogya.entity.Vaccine;
import com.jeevan.arogya.exception.VaccineNotFoundException;
import com.jeevan.arogya.implementation.VaccineServiceImpl;
import com.jeevan.arogya.service.VaccineService;


@RestController
@RequestMapping("/vaccine")
public class VaccineController {
	
	
	@Autowired
	private VaccineService vService;

	
	  // vaccine
    @GetMapping("/getallvaccine")
    public ResponseEntity<List<Vaccine>> getAllVaccines() throws VaccineNotFoundException {
        return new ResponseEntity<List<Vaccine>>(vService.allVaccine(), HttpStatus.FOUND);
    }

    @GetMapping("vaccineid/{id}")
    public ResponseEntity<Vaccine> getVaccineById(@PathVariable("id") Integer id) throws VaccineNotFoundException {
        return new ResponseEntity<Vaccine>(vService.getVaccineById(id), HttpStatus.FOUND);
    }

    @GetMapping("vaccinename/{name}")
    public ResponseEntity<Vaccine> getVaccineByName(@PathVariable("name") String name) throws VaccineNotFoundException {
        return new ResponseEntity<Vaccine>(vService.getVaccineByName(name), HttpStatus.FOUND);

    }

    @PostMapping("/addvaccine")
    public ResponseEntity<Vaccine> addVaccine(@RequestBody Vaccine vaccine) throws VaccineNotFoundException {
        return new ResponseEntity<Vaccine>(vService.addVaccine(vaccine), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deletevaccine")
    public ResponseEntity<String> deleteVaccine(@RequestBody Vaccine vaccine) throws VaccineNotFoundException {
        return new ResponseEntity<String>("Vaccine deleted : " + vService.deleteVaccine(vaccine), HttpStatus.OK);
    }

    @PutMapping("/updatevaccine")
    public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine vaccine) throws VaccineNotFoundException {
        return new ResponseEntity<Vaccine>(vService.updateVaccine(vaccine), HttpStatus.OK);
    }
	
	
	
	
	
}
