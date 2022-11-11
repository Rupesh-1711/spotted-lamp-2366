package com.jeevan.arogya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotNull
	@Size(min=1,max = 16,message = "Name length should be around 1-16")
	private String firstName;
	
	@Size(min=1,max = 16,message = "Name length should be around 1-16")
	private String lastName;
	
	@Min(value=16,message = "Minnimum Age should be 16")
	private Integer age;
	
	@Column(unique = true,length = 10)
	private String mobile;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dob;
	
	//Minimum eight characters, at least one letter and one number:
    @Size(min=6,max=20,message="Password length should be in between 6 to 20")
	private String password;
	
    @Column(unique = true)
    @Size(min=12,max=12,message="Please Enter valid Aadhar Number")
	private String aadharNo;
	
	@Embedded
    @NotNull(message = "Address can not be null")
	private Address addr;
	
}