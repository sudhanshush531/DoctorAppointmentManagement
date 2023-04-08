package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository bookingRepository;
	
	public List<Appointment> getAllBokingData() {
		Optional<List<Appointment>> bookingDetails = Optional.ofNullable(bookingRepository.findAll());
		if (!bookingDetails.isPresent()) {
			throw new NotFoundException("No data found ");
		}
		return bookingDetails.get();
	}

}
