package com.jeevan.arogya.service;

import java.util.List;

import com.jeevan.arogya.entity.Vaccine;
import com.jeevan.arogya.exception.VaccineNotFoundException;



public interface VaccineService {

	public List<Vaccine> allVaccine() throws VaccineNotFoundException;

	public Vaccine getVaccineByName(String VaccineName) throws VaccineNotFoundException;

	public Vaccine getVaccineById(Integer vaccineId)throws VaccineNotFoundException;

	public Vaccine addVaccine(Vaccine vaccine)throws VaccineNotFoundException;

	public Vaccine updateVaccine(Vaccine vaccine)throws VaccineNotFoundException;

	public boolean deleteVaccine(Vaccine vaccine)throws VaccineNotFoundException;
	
	
}
