
package com.example.online.Doctor.Portal.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service

public class Emailservice {

	
    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmailconfirm(String toEmail, String patientname, String technicianId) {
    	System.out.println("entered");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your registration is successful ");
        String mailBody = "Hello " + ",\n\n";
//        mailBody += emailRequest.getBody();
        mailBody += "\n\nBest regards,\nYour Application";
        message.setText("Dear " + patientname + ",\n\nYour ID is "+technicianId+"\n\n Using the ID we provided and password you created you can now login to our technician services. ");
        System.out.println("Sending");
        System.out.println("technicianId:::"+technicianId);

        
        javaMailSender.send(message);
        return true;
    }
}
