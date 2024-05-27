package com.example.online.Doctor.Portal.Repositary;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online.Doctor.Portal.Entity.Registration;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, String> {

	
	List<Registration>findByDiagnosticCenter(String diagnosticCenter);
	
    Registration findByEmail(String email);
    
    

	

	
}
