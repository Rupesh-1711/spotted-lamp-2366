package com.jeevan.arogya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeevan.arogya.entity.VaccinationCenter;


@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer>{

	public VaccinationCenter findByCenterCode(Integer code);


	@Query("select v from VaccinationCenter v where v.addr.city=?1")
	public List<VaccinationCenter> getByCity(String city);
	@Query("select v from VaccinationCenter v where v.addr.state=?1")
	public List<VaccinationCenter> getByState(String state);
	@Query("select v from VaccinationCenter v where v.addr.pincode=?1")
	public List<VaccinationCenter> getByPincode(String state);
	
	
}
 