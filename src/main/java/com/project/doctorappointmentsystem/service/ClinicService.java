package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Clinic;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.ClinicRepository;

@Service
public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;
	
	public List<Clinic> getAllClinicData() {
		Optional<List<Clinic>> clinics = Optional.ofNullable(clinicRepository.findAll());
		if (!clinics.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return clinics.get();
	}
}
