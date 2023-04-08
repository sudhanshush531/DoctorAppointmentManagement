package com.project.doctorappointmentsystem.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Clinic {

	@Id
	@Column(name = "clinic_id")
	private Long clinic_id;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "appointment_appointment_id")
	private Set<Appointment> appointments;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_doctor_id")
	private Set<Doctor> doctors;
	
}
