package com.Online_Physical_Consultant.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Online_Physical_Consultant.Entity.Slot_Booking_Entity;

@Repository
public interface Slot_Booking_Repository extends JpaRepository<Slot_Booking_Entity, String> {

    List<Slot_Booking_Entity> findByDoctorName(String doctorName);
    
    Slot_Booking_Entity findByPatientName(String patientName);
    
    
    List<Slot_Booking_Entity> findBypatientName(String patientName);


	List<Slot_Booking_Entity> findByAppointmentId(String appointmentId);

	List<Slot_Booking_Entity> getDoctorsByAddress(String address);


    

}
