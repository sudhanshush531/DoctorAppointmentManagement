package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Patient;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatientData() {
		Optional<List<Patient>> patientDetails = Optional.ofNullable(patientRepository.findAll());
		if (patientDetails.isEmpty()) {
			throw new NotFoundException("No data found ");
		}
		return patientDetails.get();
	}
}
