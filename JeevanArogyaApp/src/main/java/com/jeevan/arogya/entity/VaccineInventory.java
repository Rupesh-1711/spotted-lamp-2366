package com.jeevan.arogya.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer inventoryId;
	
	@OneToMany
	private List<Vaccine> vaccineList=new ArrayList<>();
	private Integer vaccineCount=vaccineList.size();
	
}
