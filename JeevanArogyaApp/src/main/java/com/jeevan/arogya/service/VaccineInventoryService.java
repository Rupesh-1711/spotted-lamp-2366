package com.jeevan.arogya.service;


import com.jeevan.arogya.entity.VaccineInventory;
import com.jeevan.arogya.exception.VaccineInventoryException;

public interface VaccineInventoryService {

	public VaccineInventory getVaccineInventoryById(Integer inventoryId) throws VaccineInventoryException;
    
	public VaccineInventory addVaccineInventory(VaccineInventory inventory, Integer id) throws VaccineInventoryException;
    
	public VaccineInventory updateVaccineInventory(VaccineInventory inventory) throws VaccineInventoryException;
    
	public VaccineInventory deleteVaccineInventory(Integer inventoryId) throws VaccineInventoryException;
}
