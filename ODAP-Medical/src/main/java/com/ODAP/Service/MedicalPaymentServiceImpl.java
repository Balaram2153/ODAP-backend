package com.ODAP.Service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODAP.Entity.MedicalPayment;
import com.ODAP.Repositery.MedicalPaymentRepo;

@Service
public class MedicalPaymentServiceImpl implements MedicalPaymentService{

	@Autowired
	MedicalPaymentRepo medicalrepo;
	
	@Override
	public MedicalPayment pay(MedicalPayment payment) {
		// TODO Auto-generated method stub
		
		  String uniqueId = generateUniqueId(payment.getTypeofservices(), payment.getPatientName(), payment.getHospitalname());
		  payment.setPaymentid(uniqueId);

		  
		return medicalrepo.save(payment);
	}

	
	
	


	private String generateUniqueId(String typeofservices, String patientName, String hospitalname) {

        char firstLetterOfTechnicianname = typeofservices.charAt(0);
        char firstLetterOfEmail = patientName.charAt(0);
        char firstLetterOfMobilenumber = hospitalname.charAt(0);

        String randomNumbers = String.valueOf(new Random().nextInt(9000) + 1000);

        return String.format("%c%c%c%s", firstLetterOfTechnicianname, firstLetterOfEmail, firstLetterOfMobilenumber, randomNumbers);
	}
}
