package com.jeevan.arogya.service;

import java.util.List;

import com.jeevan.arogya.entity.VaccinationCenter;

public interface VaccinationCenterService {

	public List<VaccinationCenter> getVaccineCenters();
	
	public VaccinationCenter getVaccineCenter(Integer code);
	
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center);
	
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center);
	
	public VaccinationCenter deleteVaccineCenter(VaccinationCenter center);

}
