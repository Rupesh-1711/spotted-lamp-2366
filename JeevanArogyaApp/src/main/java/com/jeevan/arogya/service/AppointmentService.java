package com.jeevan.arogya.service;

import com.jeevan.arogya.entity.Appointment;
import com.jeevan.arogya.entity.StatusDTO;
import com.jeevan.arogya.exception.AppointmentException;

public interface AppointmentService {

	public Appointment bookAppointment(Appointment appointment,Integer memberId) throws AppointmentException;
	
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException;
	
	public Appointment deleteAppointment(Integer appointmentId) throws AppointmentException;
	
	public StatusDTO appointmentStatus(Integer appointmentId) throws AppointmentException;
}
