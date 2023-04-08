package com.project.doctorappointmentsystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.doctorappointmentsystem.enums.AppointmentStatus;


@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appointment_id")
	private Long appointment_id;
	
	@Column(name = "appointment_date")
	private Date appointment_date;
	
	@Column(name = "appointmnet_time")
	private LocalDateTime appointment_time;
	
	@Column(name = "appointment_fees")
	private BigDecimal appointment_fees;
	
	@Column(name = "payment_status")
	private int payment_status;
	
	@Column(name = "booking_status")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus;
	
	@OneToOne(mappedBy = "appointment")
	private Feedback feedback;
	
	@OneToOne(mappedBy = "appointment")
	private Patient patient;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appointment_appointment_id")
	private Clinic clinic;
	
	@OneToOne(mappedBy = "appointment")
	private Receipt receipt;
	
}
