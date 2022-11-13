package com.jeevan.arogya.implementation;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.Appointment;
import com.jeevan.arogya.entity.Member;
import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.exception.AppointmentException;
import com.jeevan.arogya.repository.AppointmentRepository;
import com.jeevan.arogya.repository.MemberRepository;
import com.jeevan.arogya.repository.SessionRepository;
import com.jeevan.arogya.repository.UserRepository;
import com.jeevan.arogya.repository.VaccinationCenterRepository;
import com.jeevan.arogya.repository.VaccineInventoryRepository;
import com.jeevan.arogya.service.AppointmentService;
import com.jeevan.arogya.service.LoginService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	public SessionRepository sessionRepo;
	
	@Autowired
	public LoginService loginService;
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public VaccinationCenterRepository centerRepo;
	
	@Autowired
	public VaccineInventoryRepository inventoryRepo;
	
	@Autowired
	public MemberRepository memberRepo;
	
	public AppointmentRepository appointmentRepo;
	
	@Override
	public Appointment bookAppointment(Appointment appointment) throws AppointmentException {
		// TODO Auto-generated method stub
		String sessionKey=sessionRepo.getSessionKeyByUserId(userRepo.findByMobile(appointment.getMobile()).getUserId());
		
		if(sessionKey==null)
			throw new AppointmentException("Login First");
		
		Optional<VaccinationCenter> center=centerRepo.findById(appointment.getCenterCode());
		if(center.isPresent()){
			if(inventoryRepo.findById(center.get().getInventoryId()).get().getVaccineCount()>0) {
				
				Set<Member>members=userRepo.findByMobile(appointment.getMobile()).getMembers();
				Optional<Member> memberOpt=memberRepo.findById(appointment.getMemberId());
					Member member=memberOpt.get();
				if(members.contains(member)){
					if(member.getDose1()==null) {
						member.setDose1(false);
						appointmentRepo.save(appointment);
						return appointment;
					}
					else if(member.getDose2()==null) {
						member.setDose2(false);
						appointmentRepo.save(appointment);
						return appointment;
					}
					else {
						throw new AppointmentException("Member is Alredy Vaccinated");
					}
				}
				else {
					throw new AppointmentException("Member Not Found with this member Id");
				}
			}
			else {
				throw new AppointmentException("No Vaccine Available at this Center");
			}
		}
		else throw new AppointmentException("No Vaccination Center Found with given id:");
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) throws AppointmentException {
		Optional<Appointment> appointmentOpt=appointmentRepo.findById(appointment.getBookingId());
		if(appointmentOpt.isPresent()) {
			appointmentRepo.delete(appointmentOpt.get());
			appointmentRepo.save(appointment);
			return appointment;
		}
		else {
			throw new AppointmentException("appointment not found with this id");
		}
	}

	@Override
	public Appointment deleteAppointment(Appointment appointment) throws AppointmentException {
		Optional<Appointment> appointmentOpt=appointmentRepo.findById(appointment.getBookingId());
		
		if(appointmentOpt.isPresent()) {
			appointmentRepo.delete(appointment);
			return appointment;
		}
		else {
			throw new AppointmentException("No appointment found with this id");
		}
	}
}
