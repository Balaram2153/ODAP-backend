package com.doctorappointment.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {

	
    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmailconfirm(String patientEmail, String patientName, String patientId) {
    	System.out.println("entered");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(patientEmail);
        message.setSubject("Your registration is successful ");
        String mailBody = "Hello " + ",\n\n";
//        mailBody += emailRequest.getBody();
        mailBody += "\n\nBest regards,\nYour Application";
        message.setText("Dear " + patientName + ",\n\nYour ID is "+patientId+"\n\n Using the ID we provided and password you created you can now login to our technician services. ");
        System.out.println("Sending");
        System.out.println("technicianId:::"+patientId);

        
        javaMailSender.send(message);
        return true;
    }

}

