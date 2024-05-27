package com.Online_Physical_Consultant.Service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Online_Physical_Consultant.Entity.PaymentEntity;
import com.Online_Physical_Consultant.LoginResponse.LoginMessage;
import com.Online_Physical_Consultant.Repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentrepo;
	
	 @Autowired
	private JavaMailSender mailService;
	 
	@Override
	public PaymentEntity makepayment(PaymentEntity payment) {
		// TODO Auto-generated method stub
		
		int uniqueId = generateUniqueId();

        // Set the generated ID to the user
        payment.setTransactionID(uniqueId);
        PaymentEntity save = paymentrepo.save(payment);
              
    return save;
	}
	
	
	
	
	
	
	 private int generateUniqueId() {
	        // Get the first letter of each field
	        

	        // Generate random numbers (you can customize this logic)
	        int randomNumbers = Integer.valueOf(new Random().nextInt(9000) + 1000);

	        // Combine the letters and random numbers to create the unique ID
	        return randomNumbers;
	    }

	@Override
	public List<PaymentEntity> getAllPayments() {
		// TODO Auto-generated method stub
		
		return paymentrepo.findAll();
	}





	@Override
	public LoginMessage mailToPatient(PaymentEntity slot)throws MailException {
	   	String mail=slot.getPatientEmail();
				if(mail != null)
				{
					String typeOfService = slot.getTypeOfService();
					System.out.println("Entered +"+slot.getTypeOfService());
					if("Online Consulting".equals(slot.getTypeOfService()))
					{
						SimpleMailMessage message = new SimpleMailMessage();
						message.setFrom("muppuri47@gmail.com");
						message.setTo(mail);
						
						message.setSubject("Welcome to "+slot.getHospitalName()+" Your Trusted Healthcare Partner");
						String body = "Dear "+ slot.getPatientEmail()+",\r\n"
						            + "\r\n"
						            + "Welcome to "+slot.getHospitalName()+"Your dedicated healthcare partner committed to providing quality medical services. We are thrilled to have you on board!\r\n"
						            + "\r\n"
						            + "At "+slot.getHospitalName()+" we prioritize your well-being and aim to offer the best possible medical care. Whether you're seeking preventive care, diagnostic services, or specialized treatments, our experienced team of healthcare professionals is here to serve you.\r\n"
						            + "\r\n"
						            + "Appointement Details:\r\n"
						            + " Web-Link :            \r\n"
						            + " Time & Date: "+slot.getBookingTime()+" on "+slot.getBookingDate()+"\r\n"
						            + " DoctorName : "+slot.getDoctorName()+"\r\n"
						            + " DoctorMail :      \r\n"
						            + " Address:            \r\n"
						            + " Doctor Contact: +91 ********** \r\n"
						            + "\r\n"
						            + "As a registered patient, you now have access to our online portal, where you can conveniently manage appointments, view test results, and communicate with your healthcare team.\r\n"
						            + "\r\n"
						            + "We value your health and trust in us. If you have any questions, concerns, or if there's anything specific you would like assistance with, feel free to reach out to our dedicated support team.\r\n"
						            + "\r\n"
						            + "Thank you for choosing [Hospital Name] for your healthcare needs. We look forward to serving you and helping you achieve your health goals.\r\n"
						            + "\r\n"
						            + "Best regards,\r\n"
						            + "Online Doctor Service-Portal Team";

					 	message.setText(body);
				        mailService.send(message);
				        return new LoginMessage("Appointmet Details Send To E-Mail Check it Once",true);
					} 
					
//					else if(mailer.getTypeOfService() == "Physical Consulting") {
//						
//					}
					else {
						SimpleMailMessage message = new SimpleMailMessage();
						message.setFrom("srikanth336446@gmail.com");
	                        message.setTo(mail);
						
						message.setSubject("Welcome to "+slot.getHospitalName()+" Your Trusted Healthcare Partner");
						String body = "Dear "+ slot.getPatientEmail()+",\r\n"
						            + "\r\n"
						            + "Welcome to "+slot.getHospitalName()+" Your dedicated healthcare partner committed to providing quality medical services.\r\n"
						            + "\r\n"
						            + "At "+slot.getHospitalName()+" we prioritize your well-being and aim to offer the best possible medical care. Whether you're seeking preventive care, diagnostic services, or specialized treatments, our experienced team of healthcare professionals is here to serve you.\r\n"
						            + "\r\n"
						            + "Appointement Details:\r\n"
						            + " Time & Date: "+slot.getBookingTime()+" O Clock on "+slot.getBookingDate() +"\r\n"
						            + " DoctorName : "+slot.getDoctorName()+"\r\n"  
						            + " Hospital Address:  "+slot.getAddress() +"\r\n"
						            + " Doctor Contact: +91 ********** \r\n"
						            + "\r\n"
						            + "We value your health and trust in us. If you have any questions, concerns, or if there's anything specific you would like assistance with, feel free to reach out to our dedicated support team.\r\n"
						            + "\r\n"
						            + "Thank you for choosing "+slot.getHospitalName()+"  for your healthcare needs. We look forward to serving you and helping you achieve your health goals.\r\n"
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
}
