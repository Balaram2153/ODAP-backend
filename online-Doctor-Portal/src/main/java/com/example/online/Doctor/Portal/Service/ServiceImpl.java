
package com.example.online.Doctor.Portal.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.online.Doctor.Portal.Entity.Registration;
import com.example.online.Doctor.Portal.Repositary.RegistrationRepo;

@Service
public class ServiceImpl implements TechnicianService {

	@Autowired
	RegistrationRepo technicianrepo;
	
	@Autowired
	private Emailservice emailSerice;
	
	@Override
	public String saveRegistration(Registration technician) {
	    String uniqueId = generateUniqueId(technician.getTechnicianname(), technician.getEmail(), technician.getMobilenumber());
	    Registration existingTechnician = technicianrepo.findByEmail(technician.getEmail());
	    if (existingTechnician != null) {
	        return "Duplicate Email";
	    }

	    // Set the generated ID to the user
	    technician.setTechnicianId(uniqueId);
	    
	    System.out.println("UniqueId ::" + uniqueId);
	    //patient.setPatientId(generateUniqueID(patient.getPatientName(),patient.getCity(), patient.getState()));
	    Registration save = technicianrepo.save(technician);
	    return "registration done";
	}

	private String generateUniqueId(String technicianname, String email, String mobilenumber) {
		// TODO Auto-generated method stub
	    // Get the first letter of each field
        char firstLetterOfTechnicianname = technicianname.charAt(0);
        char firstLetterOfEmail = email.charAt(0);
        char firstLetterOfMobilenumber = mobilenumber.charAt(0);

        // Generate random numbers (you can customize this logic)
        String randomNumbers = String.valueOf(new Random().nextInt(9000) + 1000);

        // Combine the letters and random numbers to create the unique ID
        return String.format("%c%c%c%s", firstLetterOfTechnicianname, firstLetterOfEmail, firstLetterOfMobilenumber, randomNumbers);
	}

	
}
