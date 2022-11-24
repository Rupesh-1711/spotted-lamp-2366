package com.jeevan.arogya.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.entity.VaccineInventory;
import com.jeevan.arogya.exception.VaccineInventoryException;
import com.jeevan.arogya.repository.VaccinationCenterRepository;
import com.jeevan.arogya.repository.VaccineInventoryRepository;
import com.jeevan.arogya.service.VaccineInventoryService;

@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService{

	@Autowired
	VaccineInventoryRepository Vrepo;
	
	@Autowired
	VaccinationCenterRepository centerRepo;
	
	@Override
	public VaccineInventory getVaccineInventoryById(Integer inventoryId) throws VaccineInventoryException {
		Optional<VaccineInventory> vaccineinventory=Vrepo.findById(inventoryId);  
		if (vaccineinventory.isPresent())
			return vaccineinventory.get();

		else
			throw new VaccineInventoryException("VaccineInventory with Id " + inventoryId + " is not available");
	}

	@Override
	public VaccineInventory addVaccineInventory(VaccineInventory inventory , Integer id) throws VaccineInventoryException {
		
		Optional<VaccinationCenter> optCenter=centerRepo.findById(id);
		
		if(optCenter==null)
			throw new VaccineInventoryException("Vaccination center not found with this id:");
		VaccinationCenter center=optCenter.get();
		
		inventory.setVaccinationCenter(center);
		
		return Vrepo.save(inventory);
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException {
		Optional<VaccineInventory> opt=Vrepo.findById(inventory.getInventoryId());      
		
		if (opt.isPresent()) {
			return Vrepo.save(inventory);
		} else
			throw new VaccineInventoryException("The vaccine inventory you want to update does not exist!");
	}

	@Override
	public VaccineInventory deleteVaccineInventory(Integer inventoryId) throws VaccineInventoryException {
		
		Optional<VaccineInventory> opt=Vrepo.findById(inventoryId);      
		
		if (opt.isPresent()) {
			
			Vrepo.deleteById(inventoryId);
			
			return opt.get();
			
		} else {
			throw new VaccineInventoryException("The vaccine inventory you want to delete does not exist!");
		}
	}
}
