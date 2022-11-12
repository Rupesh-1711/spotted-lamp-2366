package com.jeevan.arogya.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Integer code;
	@NotNull
	@NotBlank
	@NotEmpty
	private String centerName;
    
	@Embedded
	Address addr;
	
}
