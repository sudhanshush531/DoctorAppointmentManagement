package com.project.doctorappointmentsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;


@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long admin_id;
	
	@Column(name = "first_name")
	private String firstName; 
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	private String email;
	
	@Column(name = "phone")
	private String phone;
}
