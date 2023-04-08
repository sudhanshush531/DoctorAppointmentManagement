package com.project.doctorappointmentsystem.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Receipt {

	@Id
	@Column(name = "receipt_id")
	private Long receipt_id;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "appointment_id")
	private Appointment appointment;
	
}
