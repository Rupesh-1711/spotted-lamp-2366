package com.jeevan.arogya.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineCode;
	private String vaccineName;
	private Integer vaccinePrice;
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Inventory_id")
	private VaccineInventory vaccineInventory;
}
