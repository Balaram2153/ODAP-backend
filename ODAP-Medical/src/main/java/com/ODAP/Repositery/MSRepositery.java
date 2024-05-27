package com.ODAP.Repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ODAP.Entity.MSEntity;


	@Repository
	public interface MSRepositery extends JpaRepository<MSEntity, String>{	

		
		List<MSEntity>findByPatientName(String patientName);
		
		List<MSEntity> findByTypeofservices(String typeofservices);
		//List<MSEntity>findByTypeOfServices(String typeofservices);

		List<MSEntity> findByPatientId(String patientId);
		
		
}
