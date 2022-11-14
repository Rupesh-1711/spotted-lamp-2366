package com.jeevan.arogya.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeevan.arogya.entity.VaccineInventory;

@Repository
public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory,Integer> {

	public Optional<VaccineInventory> findByVaccineInventory(int inventoryId);
	
	

	

	
	

}
