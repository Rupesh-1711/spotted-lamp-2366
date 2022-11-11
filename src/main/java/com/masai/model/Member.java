package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberid;
	
	private String first_name;
	private String last_name;
	
	
	private Boolean dose1status;
	private Boolean dose2status;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//	private LocalDate datefor1dose;	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//	private LocalDate datefor2dose;
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}


	


	public Member(Integer memberid, String first_name, String last_name, Boolean dose1status, Boolean dose2status) {
	super();
	this.memberid = memberid;
	this.first_name = first_name;
	this.last_name = last_name;
	this.dose1status = dose1status;
	this.dose2status = dose2status;
}





	public Integer getMemberid() {
		return memberid;
	}


	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public Boolean getDose1status() {
		return dose1status;
	}


	public void setDose1status(Boolean dose1status) {
		this.dose1status = dose1status;
	}


	public Boolean getDose2status() {
		return dose2status;
	}


	public void setDose2status(Boolean dose2status) {
		this.dose2status = dose2status;
	}


	
	
	
}
