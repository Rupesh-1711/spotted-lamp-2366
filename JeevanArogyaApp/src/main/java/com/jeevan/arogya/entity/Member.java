package com.jeevan.arogya.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	
//	@NotNull @Pattern(regexp = "[0-9]{10}",message = "Mobile number should be of 10 digits")
	
//	@NotNull
//	@Size(min=1,max = 16,message = "Name length should be around 1-16")
	private String memberName;
	
	@Column(unique = true)
//    @NotNull @Pattern(regexp = "[0-9]{10}",message = "Aadhar  number should be of 12 digits")
	private String aadharNo;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date DOB;
	
	private Boolean dose1;
	private Boolean dose2;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	
	
}
