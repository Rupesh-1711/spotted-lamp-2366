package com.jeevan.arogya.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.VaccineInventory;
import com.jeevan.arogya.exception.VaccineInventoryException;
import com.jeevan.arogya.repository.VaccineInventoryRepository;
import com.jeevan.arogya.service.VaccineInventoryService;
@Service
public class VaccineInventoryImpl implements VaccineInventoryService {
	
	
	@Autowired
	VaccineInventoryRepository iRepository;

	@Override
	public VaccineInventory getVaccineInventory(int inventoryId) throws VaccineInventoryException {
		Optional<VaccineInventory> vaccineinventory=iRepository.findById(inventoryId);  
		if (vaccineinventory.isPresent())
			return vaccineinventory.get();

		else
			throw new VaccineInventoryException("VaccineInventory with Id " + inventoryId + " is not available");
		 
		
	}

	@Override
	public VaccineInventory addVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException {
	Optional<VaccineInventory> vacc=iRepository.findById(inventory.getInventoryId());
	

	if (vacc.isPresent()) {
		 
		
		throw new RuntimeException("inventory id already exists!");
		
	}else {
		return iRepository.save(inventory);
	}
		
	
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException {
		
		Optional<VaccineInventory> opt=iRepository.findById(inventory.getInventoryId());      
		
		if (opt.isPresent()) {
			return iRepository.save(inventory);
		} else
			throw new VaccineInventoryException("The vaccine inventory you want to update does not exist!");

	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException {
		Optional<VaccineInventory> opt=iRepository.findById(inventory.getInventoryId());      
		
		if (opt.isPresent()) {
			iRepository.delete(inventory);
			return true;
		} else
			throw new VaccineInventoryException("The vaccine inventory you want to delete does not exist!");
	}
		
	


	@Override
	public List<VaccineInventory> allInventories(int inventoryId) throws VaccineInventoryException {
		

		List<VaccineInventory> list = iRepository.findAll();

		if (list.size() > 0)
			return list;
		else
			throw new VaccineInventoryException("The vaccine inventory  Doesn't Exist....");
		
		 
	}
	
	
	

}
