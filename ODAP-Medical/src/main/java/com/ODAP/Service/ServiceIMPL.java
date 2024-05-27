package com.ODAP.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ODAP.Entity.MSEntity;
import com.ODAP.Repositery.MSRepositery;

@Service
public  class ServiceIMPL implements MSService{
	
	 @Autowired
	    private MSRepositery msRepository;
	
	 
	 @Autowired
		private EmailService emailService;
	    
	
//	 public Payment savePayment(Payment payment) {
//	        // Add any business logic or validation here if needed
//	        return Paymentrepo.save(payment);
//	    }

	 @Override
		public MSEntity saveMSEntity(MSEntity msentity){    
		    String uniqueId = generateUniqueId(msentity.getPatientName(), msentity.getPatientMobileNumber(),msentity.getEmail());
		    // Set the generated ID to the technician
		    msentity.setMedicalid(uniqueId);
			emailService.sendEmailconfirm(msentity.getEmail(), msentity.getPatientName(), msentity.getBookingdate(), msentity.getSlottime(), msentity.getTypeofservices());

		    MSEntity save = msRepository.save(msentity);
		    return save;
		}
		
		private String generateUniqueId(String patientName, String email, String patientMobileNumber) {
			// TODO Auto-generated method stub
		    // Get the first letter of each field
	        char firstLetterOfTechnicianname = patientName.charAt(0);
	        char firstLetterOfEmail = email.charAt(0);
	        char firstLetterOfMobilenumber = patientMobileNumber.charAt(0);

	        // Generate random numbers (you can customize this logic)
	        String randomNumbers = String.valueOf(new Random().nextInt(9000) + 1000);

	        // Combine the letters and random numbers to create the unique ID
	        return String.format("%c%c%c%s", firstLetterOfTechnicianname, firstLetterOfEmail, firstLetterOfMobilenumber, randomNumbers);
		}
		
		public List<MSEntity> getbytypeofservices(String typeofservices) {
			
			return msRepository.findByTypeofservices(typeofservices);
		}
		


		@Override
		public List<MSEntity> getname(String patientName) {
			// TODO Auto-generated method stub
			return msRepository.findByPatientName(patientName);
		}

		
		
		

}


