package com.jeevan.arogya.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	private Date bookingDate;
	private String bookingStatus;
	
}
