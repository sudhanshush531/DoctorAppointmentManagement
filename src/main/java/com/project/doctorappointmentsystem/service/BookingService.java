package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Booking;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllBokingData() {
		Optional<List<Booking>> bookingDetails = Optional.ofNullable(bookingRepository.findAll());
		if (bookingDetails.isEmpty()) {
			throw new NotFoundException("No data found ");
		}
		return bookingDetails.get();
	}

}
