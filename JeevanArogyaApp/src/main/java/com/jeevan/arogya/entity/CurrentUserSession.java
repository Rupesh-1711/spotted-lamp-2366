package com.jeevan.arogya.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	private String sessionKey;
	private LocalDateTime sessionTime;
	
	private Integer centerId;

	public CurrentUserSession(Integer userId, String sessionKey, LocalDateTime sessionTime) {
		super();
		this.userId = userId;
		this.sessionKey = sessionKey;
		this.sessionTime = sessionTime;
	}
	
	
}
