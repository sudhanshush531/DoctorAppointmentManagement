package com.project.doctorappointmentsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Feedback {

	@Id
	@Column(name = "f_id")
	private Long f_id;
	
	@Column(name = "message")
	private String message;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "appointment_id")
	private Appointment appointment;
}
