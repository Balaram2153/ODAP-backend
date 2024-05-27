package com.doctorappointment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorappointment.entity.PatientEntity;

@Repository
public interface PatientEntityRepository extends JpaRepository<PatientEntity, String> {

	boolean existsByPatientEmail(String patientEmail);

	PatientEntity findByPatientEmail(String patientEmail);
	
	Optional<PatientEntity>  findByPatientMobileNumber(String phoneNumber);
	
}
