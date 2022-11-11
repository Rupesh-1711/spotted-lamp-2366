package com.masai.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class VaccineRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineRegisterId;
	private String mobileNo;
	
	private LocalDate dateofregistration;
	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccineRegistration")
//	private List<Member> members;

}
