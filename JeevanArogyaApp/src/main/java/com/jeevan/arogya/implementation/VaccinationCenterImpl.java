package com.jeevan.arogya.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.exception.VaccinationCenterException;
import com.jeevan.arogya.repository.VaccinationCenterRepository;
import com.jeevan.arogya.service.VaccinationCenterService;

@Service
public class VaccinationCenterImpl implements VaccinationCenterService{

	@Autowired
	private VaccinationCenterRepository vinCenter;
	//done
	@Override
	public List<VaccinationCenter> getVaccineCenters() throws VaccinationCenterException {
		   
		      List<VaccinationCenter> allVaccineCenters = vinCenter.findAll();
		      
		      if(allVaccineCenters.size()!=0) {
		    	  return allVaccineCenters;
		      }else {
		    	  throw new VaccinationCenterException("Vaccination Centers not found");
		      }
		
	}

	//done
	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center) throws VaccinationCenterException{
		                   
		VaccinationCenter newCenter =vinCenter.findByCode(center.getCode());
		if(newCenter== null) {
			return vinCenter.save(center);
		}else {
			 throw new VaccinationCenterException("Vaccination Center already exist with code : " +center.getCode());
		}
		
	}
	
	@Override
	public VaccinationCenter getVaccineCenter(Integer code) throws VaccinationCenterException{
		VaccinationCenter getCenter =vinCenter.findByCode(code);
		if(getCenter!= null) {
			return getCenter;
		}else {
			 throw new VaccinationCenterException("Vaccination Center not exist with code : " +code);
		}
		
	}



	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center) throws VaccinationCenterException{
		VaccinationCenter getCenter =vinCenter.findByCode(center.getCode());
		if(getCenter!=null) {
		        vinCenter.save(center);
		         
		         return center;
		}else {
			throw new VaccinationCenterException("Vaccination Center Not exist with code : " +center.getCode());
		}
		 
	}

	@Override
	public VaccinationCenter deleteVaccineCenter(Integer code) throws VaccinationCenterException{
		
		VaccinationCenter getCenter =vinCenter.findByCode(code);
		if(getCenter!=null) {
			     vinCenter.delete(getCenter);
			     return getCenter;
		}else {
			throw new VaccinationCenterException("Vaccination Center Not exist with code : " +code);
		}
	}

	@Override
	public List<VaccinationCenter> getVaccineCenterByState(String state) throws VaccinationCenterException{
                 
		         List<VaccinationCenter> list = vinCenter.getByState(state);
		         
		         if(list.size()==0) {
		        	 throw new VaccinationCenterException("Vaccination Center not found in this State: "+state);
		         }else {
		        	 return list;
		         }
		
	}

	@Override
	public List<VaccinationCenter> getVaccineCenterByCity(String city) throws VaccinationCenterException{
		  List<VaccinationCenter> list = vinCenter.getByCity(city);
	         
	         if(list.size()==0) {
	        	 throw new VaccinationCenterException("Vaccination Center not found in this city: "+city);
	         }else {
	        	 return list;
	         }
	}

	@Override
	public List<VaccinationCenter> getVaccineCenterByPincode(String Pincode) throws VaccinationCenterException{
		  List<VaccinationCenter> list = vinCenter.getByPincode(Pincode);
	         
	         if(list.size()==0) {
	        	 throw new VaccinationCenterException("Vaccination Center not found with this Pincod: "+Pincode);
	         }else {
	        	 return list;
	         }
	}

}
