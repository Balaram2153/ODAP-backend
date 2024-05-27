package com.ODAP.DRRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ODAP.DREntity.DREntity;

@Repository
public interface DRRepository extends JpaRepository<DREntity, String> {

	List<DREntity> findAllBySpeciality(String speciality);
	
	List<DREntity> findByDoctorName(String doctorName);

	List<DREntity> findBySpecialityContainingIgnoreCase(String speciality);
	
   DREntity findByEmail(String email);
	

	
}
