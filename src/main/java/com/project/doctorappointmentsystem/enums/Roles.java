package com.project.doctorappointmentsystem.enums;

public enum Roles {

ADMIN("admin"), USER("user"), DOCTOR("doctor");
	
	private String role;

	Roles(String role) {
        this.role = role;
    }

    public String getRoles() {
        return role;
    }
}
