package com.project.doctorappointmentsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.doctorappointmentsystem.entity.Appointment;
import com.project.doctorappointmentsystem.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

//	List<Booking> findBookingsByPatient_id(Long patient_id);
}
