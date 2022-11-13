package com.jeevan.arogya.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.Appointment;
import com.jeevan.arogya.exception.AppointmentException;
import com.jeevan.arogya.repository.SessionRepository;
import com.jeevan.arogya.repository.UserRepository;
import com.jeevan.arogya.service.AppointmentService;
import com.jeevan.arogya.service.LoginService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	public SessionRepository sessionRepo;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public Appointment bookAppointment(Appointment appointment) throws AppointmentException {
		// TODO Auto-generated method stub
		String sessionKey=sessionRepo.getSessionKeyByUserId(userRepo.findByMobile(appointment.getMobile()).getUserId());
		
		if(sessionKey==null)
			throw new AppointmentException("Login First");
		
		
		return null;
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment deleteAppointment(Appointment appointment) throws AppointmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String appointmentStatus(Integer appointmentId) throws AppointmentException {
		// TODO Auto-generated method stub
		return null;
	}

}
