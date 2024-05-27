package com.doctorappointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorappointment.entity.TreatmentEntity;

@Repository
public interface TreatmentRepository extends JpaRepository<TreatmentEntity,Long> {

	
	
    List<TreatmentEntity> findByDoctorName(String doctorName);

}
