package com.jeevan.arogya.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.Appointment;
import com.jeevan.arogya.entity.Member;
import com.jeevan.arogya.entity.StatusDTO;
import com.jeevan.arogya.entity.User;
import com.jeevan.arogya.entity.VaccinationCenter;
import com.jeevan.arogya.entity.Vaccine;
import com.jeevan.arogya.entity.VaccineInventory;
import com.jeevan.arogya.exception.AppointmentException;
import com.jeevan.arogya.repository.AppointmentRepository;
import com.jeevan.arogya.repository.MemberRepository;
import com.jeevan.arogya.repository.SessionRepository;
import com.jeevan.arogya.repository.UserRepository;
import com.jeevan.arogya.repository.VaccinationCenterRepository;
import com.jeevan.arogya.repository.VaccineInventoryRepository;
import com.jeevan.arogya.repository.VaccineRepository;
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
	
	@Autowired
	public AppointmentRepository appointmentRepo;
	
	@Autowired
	public VaccinationCenterRepository centerRepo;
	
	@Autowired
	public VaccineInventoryRepository iRepo;
	
	@Autowired
	public MemberRepository mRepo;
	
	@Autowired
	public VaccineRepository vaccineRepo;
	
	
	@Override
	public Appointment bookAppointment(Appointment appointment,Integer memberId) throws AppointmentException {
		
		Optional<Member>optMember=mRepo.findById(memberId);
		User user=optMember.get().getUser();
		
		String sessionKey=sessionRepo.getSessionKeyByUserId(user.getUserId());
		
		if(sessionKey==null)
			throw new AppointmentException("Login First");
		
			VaccinationCenter center=centerRepo.findByCenterCode(appointment.getCenterId());
		
		if(center == null)
			throw new AppointmentException("No Vaccination Center Found with given id:");
			center.getAppointmentList().add(appointment);
			
			VaccineInventory inventory=iRepo.getInventoryByCenterID(center.getCenterCode());
			
		if(inventory==null)
			throw new AppointmentException("No Vaccine inventory");
		
			List<Vaccine> vaccineList=vaccineRepo.getVaccinesByInventory(inventory.getInventoryId());
			
		if(vaccineList.size()<1)
			throw new AppointmentException("Vaccine Not Available for now");
		
		appointment.setMember(optMember.get());
		
		return appointmentRepo.save(appointment);
	
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
	public Appointment deleteAppointment(Integer appointmentId) throws AppointmentException {
		Optional<Appointment> appointmentOpt=appointmentRepo.findById(appointmentId);

		if(appointmentOpt.isPresent()) {
			appointmentRepo.delete(appointmentOpt.get());
			return appointmentOpt.get();
		}
		else {
			throw new AppointmentException("No appointment found with this id");
		}
	}

	@Override
	public StatusDTO appointmentStatus(Integer appointmentId) throws AppointmentException {
		
		Optional<Appointment>appointmentOpt=appointmentRepo.findById(appointmentId);
		
		if(appointmentOpt.isPresent()) {
			StatusDTO status=new StatusDTO();
			Appointment appointment=appointmentOpt.get();
			
			Optional<VaccinationCenter> center=centerRepo.findById(appointment.getCenterId());
			
			status.setBookingId(appointment.getBookingId());
			status.setCenterName(center.get().getCenterName());
			status.setMemberName(appointment.getMember().getMemberName());
			status.setStatus(appointment.getBookingStatus());
			
			if(appointment.getMember().getDose1()==null) {
				status.setDose("1st");
			}
			else {
				status.setDose("2nd");
			}
			
			return status;
		}
		else {
			throw new AppointmentException("No appointment found with this appointment id");
		}
	}

}
