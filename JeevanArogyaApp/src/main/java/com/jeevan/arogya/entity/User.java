package com.jeevan.arogya.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
//	@NotNull
//	@Size(min=1,max = 16,message = "Name length should be around 1-16")
	private String firstName;
	
//	@Size(min=1,max = 16,message = "Name length should be around 1-16")
	private String lastName;
	
//	@Min(value=16,message = "Minnimum Age should be 16")
	private Integer age;
	
//	@NotNull @Pattern(regexp = "[0-9]{10}",message = "Mobile number should be of 10 digits")
	private String mobile;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dob;
	
//	@Pattern(regexp = "[A-Za-z0-9@]{6,15}",message = "Password must be 6 to 15 characters and must have at least 1 alphabate and 1 number")
//	@NotNull @NotBlank @NotEmpty
	private String password;
	
//    @Column(unique = true)
//    @NotNull @Pattern(regexp = "[0-9]{12}",message = "Aadhar  number should be of 12 digits")
	private String aadharNo;
	
	@Embedded
//	@NotNull(message = "Address can not be null")
	private Address addr;
	
	@OneToMany(mappedBy = "user")
	private List<Member> listMembers = new ArrayList<>();
	
	
}