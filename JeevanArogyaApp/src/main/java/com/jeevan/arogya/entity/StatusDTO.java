package com.jeevan.arogya.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StatusDTO {

	private Integer bookingId;
	private String memberName;
	private Status status;
	private String dose;
	private String centerName;
}
