package com.jeevan.arogya.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeevan.arogya.entity.Vaccine;
import com.jeevan.arogya.entity.VaccineInventory;
import com.jeevan.arogya.exception.VaccineNotFoundException;
import com.jeevan.arogya.repository.VaccineInventoryRepository;
import com.jeevan.arogya.repository.VaccineRepository;
import com.jeevan.arogya.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepository vRepo;
	
	@Autowired
	private VaccineInventoryRepository inventoryRepo;
	
	@Override
	public List<Vaccine> allVaccine() throws VaccineNotFoundException {
		
		List<Vaccine> list = vRepo.findAll();
		if (list.size() > 0)
			return list;
		else
			throw new VaccineNotFoundException("No Vaccine Found....");
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
	public Vaccine addVaccine(Vaccine vaccine,Integer inventoryId) throws VaccineNotFoundException {
		
		Optional<VaccineInventory> inventoryOpt =inventoryRepo.findById(inventoryId);
		
		if(inventoryOpt==null)
			throw new VaccineNotFoundException("Inventory Not found with this id:");
		
		vaccine.setVaccineInventory(inventoryOpt.get());
		
		return vRepo.save(vaccine);
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
	public Vaccine deleteVaccine(Integer vaccineId) throws VaccineNotFoundException {
		Optional<Vaccine> opt = vRepo.findById(vaccineId);

		if (opt.isPresent()) {
			vRepo.delete(opt.get());
			return opt.get();
		} else
			throw new VaccineNotFoundException("The vaccine you want to delete does not exist!");
	}
}
