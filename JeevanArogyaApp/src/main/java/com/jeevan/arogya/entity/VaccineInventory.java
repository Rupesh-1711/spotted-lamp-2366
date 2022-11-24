package com.jeevan.arogya.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Inventory")
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer inventoryId;
	private String inventoryName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="center_id")
	VaccinationCenter vaccinationCenter;
	
	
	
}
