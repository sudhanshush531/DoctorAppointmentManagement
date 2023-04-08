package com.project.doctorappointmentsystem.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.doctorappointmentsystem.enums.Department;
import com.project.doctorappointmentsystem.enums.Roles;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private Long doctor_id;

	@Column(name = "first_name")
	private String firstName; 
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "department")
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "appointment_appointment_id")
	private Set<Appointment> appointments;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_doctor_id")
	private Clinic clinic;

}
