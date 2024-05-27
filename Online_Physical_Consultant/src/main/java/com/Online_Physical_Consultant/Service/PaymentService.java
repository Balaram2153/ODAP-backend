package com.Online_Physical_Consultant.Service;

import java.util.List;

import com.Online_Physical_Consultant.Entity.PaymentEntity;
import com.Online_Physical_Consultant.Entity.Slot_Booking_Entity;
import com.Online_Physical_Consultant.LoginResponse.LoginMessage;

public interface PaymentService {
	
	public PaymentEntity makepayment(PaymentEntity payment);
	
	public List<PaymentEntity> getAllPayments();
	
    LoginMessage mailToPatient(PaymentEntity slot);


}
