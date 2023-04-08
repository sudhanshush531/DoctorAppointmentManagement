package com.project.doctorappointmentsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;


@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patient_id;
	
	@Column(name = "first_name")
	private String firstName; 
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "appointment_id")
	private Appointment appointment;

}
