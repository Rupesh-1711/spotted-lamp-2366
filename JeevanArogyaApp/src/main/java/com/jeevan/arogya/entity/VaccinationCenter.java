package com.jeevan.arogya.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Integer code;
	private String centerName;
    
	@Embedded
	Address addr;
	
}
