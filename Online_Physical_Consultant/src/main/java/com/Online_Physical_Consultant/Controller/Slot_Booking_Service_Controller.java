package com.Online_Physical_Consultant.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Online_Physical_Consultant.Entity.Slot_Booking_Entity;
import com.Online_Physical_Consultant.LoginResponse.LoginMessage;
import com.Online_Physical_Consultant.Repository.Slot_Booking_Repository;
import com.Online_Physical_Consultant.Service.Slot_Booking_Service;
import com.Online_Physical_Consultant.Service.Slot_Booking_ServiceImplementation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class Slot_Booking_Service_Controller 
{
          @Autowired
         Slot_Booking_ServiceImplementation service;
          
         @Autowired
         Slot_Booking_Service slotservice;
         
         @Autowired
         Slot_Booking_Repository repo; 
         
        @GetMapping("/{appointmentId}")
	    public ResponseEntity<Slot_Booking_Entity> getServiceById(@PathVariable String appointmentId) {
	        Optional<Slot_Booking_Entity> poj = service.getServiceById(appointmentId);
	        return poj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    
	    
	    @GetMapping("/get/{doctorName}")
		public List<Slot_Booking_Entity> finddoctorName(@PathVariable String doctorName) {
			
			
			return service.finddoctorName(doctorName); 
		}
	    
		@GetMapping("/getpatient/{patientName}")
	    public ResponseEntity<Slot_Booking_Entity> getCandidateByUniqueId(@PathVariable String patientName) {
	    	Slot_Booking_Entity candidate = repo.findByPatientName(patientName);
	        if (candidate != null) {
	            return new ResponseEntity<>(candidate, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


		
		@GetMapping("/getname/{patientName}")
		public List<Slot_Booking_Entity> findpatientName(@PathVariable String patientName) {
			
			
			return slotservice.findName(patientName);
 
		}
	    
		@GetMapping("/raju/{appointmentId}")
		public List<Slot_Booking_Entity> findpatient(@PathVariable String appointmentId) {
			
			
			return repo.findByAppointmentId(appointmentId);
 
		}
	    
		
        
	    @GetMapping("/all")
	    public List<Slot_Booking_Entity> getAllService() {
	        List<Slot_Booking_Entity> poj = service.getAllService();
	        return poj;
	    }
	    
	    
	    
	    
	    
	    @PostMapping("/save")
	    public Slot_Booking_Entity createService(@RequestBody Slot_Booking_Entity pojo){

	    	return service.addService(pojo);
	    }
	    
	    @PutMapping("/updateservice/{appointmentId}")
	    public void updateServiceById(@PathVariable String appointmentId,@RequestBody Slot_Booking_Entity update) {
	    	 service.updateService( appointmentId,update);
	    }

	    
	    @DeleteMapping("/{appointmentId}")
	    public ResponseEntity<String> deleteById(@PathVariable String appointmentId) {
	        String result = service.deleteService(appointmentId);
	        return ResponseEntity.ok(result);
	    }
	    
	    @PostMapping("/details")
		public LoginMessage mailAppointmentDetails(@RequestBody Slot_Booking_Entity pojo) {
			LoginMessage message = service.mailToPatient(pojo);
			return message;
		}	    
}