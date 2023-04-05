package com.project.doctorappointmentsystem.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Pattern;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long admin_id;
	
	@Column(name = "username")
	private String username; 
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email", unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	private String email;
	
	@Column(name = "phone")
	private String phone;
}
