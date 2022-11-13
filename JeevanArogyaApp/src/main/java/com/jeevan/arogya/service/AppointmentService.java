package com.jeevan.arogya.service;

import com.jeevan.arogya.entity.Appointment;
import com.jeevan.arogya.exception.AppointmentException;

public interface AppointmentService {

	public Appointment bookAppointment(Appointment appointment) throws AppointmentException;
	
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException;
	
	public Appointment deleteAppointment(Appointment appointment) throws AppointmentException;
	
}
