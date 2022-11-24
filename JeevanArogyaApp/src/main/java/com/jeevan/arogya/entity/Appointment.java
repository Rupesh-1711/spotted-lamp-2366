package com.jeevan.arogya.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	
	@JsonIgnore
	private LocalDateTime bookingDate=LocalDateTime.now() ;
	
	@Enumerated(EnumType.STRING)
	private Status bookingStatus;
	
	@NotNull
	private Integer centerId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="member_id")
	private Member member;
	
	
	
}
