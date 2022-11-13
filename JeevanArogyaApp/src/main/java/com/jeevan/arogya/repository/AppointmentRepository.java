package com.jeevan.arogya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeevan.arogya.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	@Query("select a.bookingStatus from Appointment a where a.bookingId=?1")
	public String getBookingStatusById(Integer bookingId);

}
