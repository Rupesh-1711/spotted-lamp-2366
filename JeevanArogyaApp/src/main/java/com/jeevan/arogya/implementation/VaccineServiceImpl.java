package com.jeevan.arogya.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.Vaccine;
import com.jeevan.arogya.exception.VaccineNotFoundException;
import com.jeevan.arogya.repository.VaccineRepositary;
import com.jeevan.arogya.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	VaccineRepositary vRepo;

	@Override
	public List<Vaccine> allVaccine() throws VaccineNotFoundException {

		List<Vaccine> list = vRepo.findAll();

		if (list.size() > 0)
			return list;
		else
			throw new VaccineNotFoundException("Vaccine Doesn't Exist....");
	}

	@Override
	public Vaccine getVaccineByName(String VaccineName) throws VaccineNotFoundException {

		Optional<Vaccine> vaccine = vRepo.findByVaccineName(VaccineName);

		if (vaccine != null)
			return vaccine.get();
		else
			throw new VaccineNotFoundException("Vaccine with name " + VaccineName + " in not available");

	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineNotFoundException {
		Optional<Vaccine> opt = vRepo.findById(vaccineId);

		if (opt.isPresent())
			return opt.get();

		else
			throw new VaccineNotFoundException("Vaccine with Id " + vaccineId + " is not available");

	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineNotFoundException {
		Optional<Vaccine> vacc = vRepo.findByVaccineName(vaccine.getVaccineName());

		if (vacc.isPresent()) {

			
			throw new RuntimeException("Vaccine already exists!");
			
		}else {
			return vRepo.save(vaccine);
		}
		
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineNotFoundException {
		Optional<Vaccine> opt = vRepo.findById(vaccine.getVaccineCode());

		if (opt.isPresent()) {
			return vRepo.save(vaccine);
		} else
			throw new VaccineNotFoundException("The vaccine you want to update does not exist!");

	}

	@Override
	public boolean deleteVaccine(Vaccine vaccine) throws VaccineNotFoundException {
		Optional<Vaccine> opt = vRepo.findById(vaccine.getVaccineCode());

		if (opt.isPresent()) {
			vRepo.delete(vaccine);
			return true;
		} else
			throw new VaccineNotFoundException("The vaccine you want to delete does not exist!");
	}

}
