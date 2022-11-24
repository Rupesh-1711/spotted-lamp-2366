package com.jeevan.arogya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeevan.arogya.entity.VaccineInventory;

@Repository
public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory, Integer> {

	@Query("select i from VaccineInventory i where i.vaccinationCenter.centerCode=?1")
	public VaccineInventory getInventoryByCenterID(Integer centerId);
}
