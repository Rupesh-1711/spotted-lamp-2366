package com.jeevan.arogya.service;

import java.util.List;

import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.exception.VaccinationCenterException;

public interface VaccinationCenterService {

	public List<VaccinationCenter> getVaccineCenters();
	
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center);

	public List<VaccinationCenter> getVaccineCenterByState(String state)throws VaccinationCenterException;
	
	public List<VaccinationCenter> getVaccineCenterByCity(String City)throws VaccinationCenterException;
	
	public List<VaccinationCenter> getVaccineCenterByPincode(String Pincode)throws VaccinationCenterException;
	
	public VaccinationCenter getVaccineCenter(Integer code);
	

	
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center);
	
	public VaccinationCenter deleteVaccineCenter(VaccinationCenter center);

}
