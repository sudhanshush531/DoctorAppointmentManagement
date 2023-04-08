package com.project.doctorappointmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.doctorappointmentsystem.entity.Admin;
import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;


	@Operation(summary = "Fetch All the Appointment Data", description = "This API will Fetch All the Appointment Data", parameters = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Booking Details data Found Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Admin.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid data supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
	@GetMapping("/all")
	public List<Appointment> getAllBookingDetails() {
		return appointmentService.getAllBokingData();
	}
}
