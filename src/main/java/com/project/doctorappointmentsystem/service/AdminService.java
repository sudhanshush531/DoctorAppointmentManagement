package com.project.doctorappointmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.doctorappointmentsystem.entity.Admin;
import com.project.doctorappointmentsystem.exception.NotFoundException;
import com.project.doctorappointmentsystem.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public List<Admin> getAllAdminData() {
		Optional<List<Admin>> bankDetails = Optional.ofNullable(adminRepository.findAll());
		if (bankDetails.isEmpty()) {
			throw new NotFoundException("No data found ");
		}
		return bankDetails.get();
	}
}
