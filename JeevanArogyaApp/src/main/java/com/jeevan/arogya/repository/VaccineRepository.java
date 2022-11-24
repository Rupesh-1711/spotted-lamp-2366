package com.jeevan.arogya.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeevan.arogya.entity.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer>{


	@Query("select v from Vaccine v where v.vaccineInventory.inventoryId=?1")
	public List<Vaccine> getVaccinesByInventory(Integer inventoryId);
}
