package com.jeevan.arogya.service;

import java.util.List;

import com.jeevan.arogya.entity.VaccineInventory;
import com.jeevan.arogya.exception.VaccineInventoryException;

public interface VaccineInventoryService{
	
	
	
 	 public VaccineInventory getVaccineInventory(int inventoryId) throws VaccineInventoryException;
     public VaccineInventory addVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException;
     public VaccineInventory updateVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException;
     public boolean deleteVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException;
   
 	public List<VaccineInventory> allInventories(int inventoryId) throws VaccineInventoryException;
		
 		
	 
	
}
