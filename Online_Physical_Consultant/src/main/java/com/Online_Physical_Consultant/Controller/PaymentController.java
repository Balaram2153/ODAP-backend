package com.Online_Physical_Consultant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Online_Physical_Consultant.Entity.PaymentEntity;
import com.Online_Physical_Consultant.Entity.Slot_Booking_Entity;
import com.Online_Physical_Consultant.LoginResponse.LoginMessage;
import com.Online_Physical_Consultant.Service.PaymentService;

@RestController
@CrossOrigin("*")
public class PaymentController {
	
	@Autowired
	PaymentService paymentservice;
	
	@PostMapping("/payment")
    public PaymentEntity makepayment(@RequestBody PaymentEntity payments)
    {
    	
    	return paymentservice.makepayment(payments);
    	
    }
	
	@GetMapping("/allpayments")
	public List<PaymentEntity> getAllPayments()
	{
		return paymentservice.getAllPayments();
		
	}
	
	@PostMapping("/details")
	public LoginMessage mailAppointmentDetails(@RequestBody PaymentEntity slot) {
		LoginMessage message = paymentservice.mailToPatient(slot);
		return message;
	}

}
