package com.project.doctorappointmentsystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.project.doctorappointmentsystem.enums.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long booking_id;
	
	@Column(name = "booking_date")
	private Date booking_date;
	
	@Column(name = "appointmnet_time")
	private LocalDateTime appointment_time;
	
	@Column(name = "appointment_fees")
	private BigDecimal appointment_fees;
	
	@Column(name = "payment_status")
	private int payment_status;
	
	@Column(name = "booking_status")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus bookingStatus;
	
	
	
}
