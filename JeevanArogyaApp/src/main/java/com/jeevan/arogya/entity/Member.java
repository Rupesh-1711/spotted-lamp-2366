package com.jeevan.arogya.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String mobile;
	
//	@NotNull
//	@Size(min=1,max = 16,message = "Name length should be around 1-16")
	private String memberName;
	
//	@Column(unique = true)
//    @NotNull @Pattern(regexp = "[0-9]{10}",message = "Aadhar  number should be of 12 digits")
	private String aadharNo;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date DOB;
	
	private boolean dose1=false;
	private boolean dose2=false;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	
	
}
