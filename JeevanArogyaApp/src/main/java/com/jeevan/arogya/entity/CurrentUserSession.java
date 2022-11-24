package com.jeevan.arogya.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Session")
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	private String sessionKey;
	private LocalDateTime sessionTime;
	
}
