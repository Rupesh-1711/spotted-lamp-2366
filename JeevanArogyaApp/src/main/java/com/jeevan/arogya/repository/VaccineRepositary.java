package com.jeevan.arogya.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeevan.arogya.entity.Vaccine;

public interface VaccineRepositary extends JpaRepository<Vaccine, Integer>{
	
	public Optional<Vaccine> findByVaccineName(String name);
	
	
}
