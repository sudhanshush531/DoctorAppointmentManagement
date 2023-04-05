package com.project.doctorappointmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.doctorappointmentsystem.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
