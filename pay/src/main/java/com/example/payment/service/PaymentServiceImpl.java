package com.example.payment.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl {
	
	@Autowired
	PaymentRepository paymentrepository;
	
	public Payment savePayment(Payment payment){    
	    String uniqueId = generateUniqueId(payment.getTypeofservices(),payment.getPatientName(), payment.getSlottime());
	    
	    System.out.println("Id ::"+uniqueId);
	    payment.setPaymentid(uniqueId);
	    
	    System.out.println(" pamenet ::"+uniqueId);
	    Payment save = paymentrepository.save(payment);

	    return save;
	}
	


	private String generateUniqueId(String typeofservices, String patientName, String slottime) {

        char firstLetterOfTechnicianname = typeofservices.charAt(0);
        char firstLetterOfEmail = patientName.charAt(0);
        char firstLetterOfMobilenumber = slottime.charAt(0);

        String randomNumbers = String.valueOf(new Random().nextInt(9000) + 1000);

        return String.format("%c%c%c%s", firstLetterOfTechnicianname, firstLetterOfEmail, firstLetterOfMobilenumber, randomNumbers);
	}
	

	
	
}
