package com.jeevan.arogya.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "Center")
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Integer centerCode;
	
	@NotEmpty
	private String centerName;
    
	@Embedded
	Address addr;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="appointment_id")
	List<Appointment> appointmentList;
}
