package com.Online_Physical_Consultant.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.Online_Physical_Consultant.Entity.Slot_Booking_Entity;
import com.Online_Physical_Consultant.LoginResponse.LoginMessage;


public interface Slot_Booking_Service 
{
	
	public Slot_Booking_Entity addService(Slot_Booking_Entity pojo);

    Optional<Slot_Booking_Entity> getServiceById(String appointmentId);

   public void  updateService(String appointmentId,Slot_Booking_Entity update);

    String deleteService(String appointmentId);

    List<Slot_Booking_Entity> getAllService();
    
    List<Slot_Booking_Entity>finddoctorName(String doctorName);

    List<Slot_Booking_Entity> findName(String patientName);
    
    LoginMessage mailToPatient(Slot_Booking_Entity slot);

    
}
