package com.doctorappointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//MedicineFormRepo.java

import org.springframework.stereotype.Repository;

import com.doctorappointment.entity.MedicineFormEntity;


@Repository
public interface MedicineFormRepo extends JpaRepository<MedicineFormEntity ,Long> {

	//List<MedicineFormEntity> findByName(String name);
	
	   @Query("SELECT m FROM MedicineFormEntity m WHERE m.name LIKE %:name%")
	    List<MedicineFormEntity> findByNameContaining(@Param("name") String name);
	
}
