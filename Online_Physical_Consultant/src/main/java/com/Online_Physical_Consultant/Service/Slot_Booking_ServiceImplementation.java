package com.Online_Physical_Consultant.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Online_Physical_Consultant.Entity.Slot_Booking_Entity;
import com.Online_Physical_Consultant.LoginResponse.LoginMessage;
import com.Online_Physical_Consultant.Repository.Slot_Booking_Repository;

@Service
public class Slot_Booking_ServiceImplementation implements Slot_Booking_Service 
   {

	    @Autowired
	    private Slot_Booking_Repository repo;
	    
	    @Autowired
		private JavaMailSender mailService;


	    @Override
	    public Optional<Slot_Booking_Entity> getServiceById(String appointmentId) {
	        return repo.findById(appointmentId);
	    }
	    
	    
          @Override
          public Slot_Booking_Entity addService(Slot_Booking_Entity pojo) {
	        
        	   String uniqueId = generateUniqueId(pojo.getPatientName(), pojo.getGender(),pojo.getPatientId());

		        // Set the generated ID to the user
		        pojo.setAppointmentId(uniqueId);
			//patient.setPatientId(generateUniqueID(patient.getPatientName(),patient.getCity(), patient.getState()));
		        Slot_Booking_Entity save = repo.save(pojo);
	            return save;
	        
	    }
          
          private String generateUniqueId(String patientName, String gender, String patientId) {
  	        // Get the first letter of each field
  	        char firstLetterOfName = patientName.charAt(0);
  	        char firstLetterOfCity = gender.charAt(0);
  	        char firstLetterOfState = patientId.charAt(0);

  	        // Generate random numbers (you can customize this logic)
  	        String randomNumbers = String.valueOf(new Random().nextInt(9000) + 1000);

  	        // Combine the letters and random numbers to create the unique ID
  	        return String.format("%c%c%c%s", firstLetterOfName, firstLetterOfCity, firstLetterOfState, randomNumbers);
  	    }

	    @Override
	    public String deleteService(String appointmentId) {
	               repo.deleteById(appointmentId);
	        return "Deleted Successfully ";
	    }

	    
	    @Override
	    public void  updateService(String appointmentId,Slot_Booking_Entity update) {
			
				
	    	Optional<Slot_Booking_Entity> custo=repo.findById(appointmentId);
			if(custo.isPresent()) {
				
				custo.get().setBookingDate(update.getBookingDate());
				custo.get().setBookingTime(update.getBookingTime());
				repo.save(custo.get());
			}else {
				System.out.println("no Id found");
			}
			
			
		}
	    
	    
	    @Override
	    public List<Slot_Booking_Entity> getAllService() {
	        return repo.findAll();   
	    }
	    
	    @Override
		public LoginMessage mailToPatient(Slot_Booking_Entity mailer) throws MailException
		{
	    	String mail=mailer.getPatientEmail();
			if(mail != null)
			{
				String typeOfService = mailer.getTypeOfService();
				System.out.println("Entered +"+mailer.getTypeOfService());
				if("Online Consulting".equals(mailer.getTypeOfService()))
				{
					SimpleMailMessage message = new SimpleMailMessage();
					message.setFrom("muppuri47@gmail.com");
					message.setTo(mail);
					
					message.setSubject("Welcome to "+mailer.getHospitalName()+" Your Trusted Healthcare Partner");
					String body = "Dear "+ mailer.getPatientEmail()+",\r\n"
					            + "\r\n"
					            + "Welcome to "+mailer.getHospitalName()+"Your dedicated healthcare partner committed to providing quality medical services. We are thrilled to have you on board!\r\n"
					            + "\r\n"
					            + "At "+mailer.getHospitalName()+" we prioritize your well-being and aim to offer the best possible medical care. Whether you're seeking preventive care, diagnostic services, or specialized treatments, our experienced team of healthcare professionals is here to serve you.\r\n"
					            + "\r\n"
					            + "Appointement Details:\r\n"
					            + " Web-Link : "+ mailer.getWebLink()+"\r\n"
					            + " Time & Date: "+mailer.getBookingTime()+" on "+mailer.getBookingDate() +"\r\n"
					            + " DoctorName : "+mailer.getDoctorName()+"\r\n"					           
					            + " Address:  "+mailer.getAddress()+"\r\n"
					            + "\r\n"
					            + "As a registered patient, you now have access to our online portal, where you can conveniently manage appointments, view test results, and communicate with your healthcare team.\r\n"
					            + "\r\n"
					            + "We value your health and trust in us. If you have any questions, concerns, or if there's anything specific you would like assistance with, feel free to reach out to our dedicated support team.\r\n"
					            + "\r\n"
					            + "Thank you for choosing "+mailer.getHospitalName()+" for your healthcare needs. We look forward to serving you and helping you achieve your health goals.\r\n"
					            + "\r\n"
					            + "Best regards,\r\n"
					            + "Online Doctor Service-Portal Team";

				 	message.setText(body);
			        mailService.send(message);
			        return new LoginMessage("Appointmet Details Send To E-Mail Check it Once",true);
				} 
				
//				else if(mailer.getTypeOfService() == "Physical Consulting") {
//					
//				}
				else {
					SimpleMailMessage message = new SimpleMailMessage();
					message.setFrom("srikanth336446@gmail.com");
                        message.setTo(mail);
					
					message.setSubject("Welcome to "+mailer.getHospitalName()+" Your Trusted Healthcare Partner");
					String body = "Dear "+ mailer.getPatientEmail()+",\r\n"
					            + "\r\n"
					            + "Welcome to "+mailer.getHospitalName()+" Your dedicated healthcare partner committed to providing quality medical services.\r\n"
					            + "\r\n"
					            + "At "+mailer.getHospitalName()+" we prioritize your well-being and aim to offer the best possible medical care. Whether you're seeking preventive care, diagnostic services, or specialized treatments, our experienced team of healthcare professionals is here to serve you.\r\n"
					            + "\r\n"
					            + "Appointement Details:\r\n"
					            + " Time & Date: "+mailer.getBookingTime()+" O Clock on "+mailer.getBookingDate() +"\r\n"
					            + " DoctorName : "+mailer.getDoctorName()+"\r\n"  
					            + " Hospital Address:  "+mailer.getAddress() +"\r\n"
					            + " Doctor Contact: +91 ********** \r\n"
					            + "\r\n"
					            + "We value your health and trust in us. If you have any questions, concerns, or if there's anything specific you would like assistance with, feel free to reach out to our dedicated support team.\r\n"
					            + "\r\n"
					            + "Thank you for choosing "+mailer.getHospitalName()+"  for your healthcare needs. We look forward to serving you and helping you achieve your health goals.\r\n"
					            + "\r\n"
					            + "Best regards,\r\n"
					            + "Online Doctor Service-Portal Team";
				 	    message.setText(body);
			           mailService.send(message);
					   return new LoginMessage("Appointmet Details Send To E-Mail check it Once",true);
				}
			}else {
				  return new LoginMessage("Wrong E-Mail check it Once",false);
			}
	}
		@Override
		public List<Slot_Booking_Entity> finddoctorName(String doctorName) {
			// TODO Auto-generated method stub
			return repo.findByDoctorName(doctorName);
		}
		
		@Override
	   public List<Slot_Booking_Entity> findName(String patientName)
	    {
	    	return repo.findBypatientName(patientName);
	    }

}