package com.ODAP.Service;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmailconfirm(String toEmail, String patientName, Date bookingdate, String slottime, String typeofservices) {
    	System.out.println("entered");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your slot is confirmed ");
        String mailBody = "Hello " + ",\n\n";
//        mailBody += emailRequest.getBody();
        mailBody += "\n\nBest regards,\nYour Application";
        message.setText("Dear " + patientName + ",\n\nThank you for booking your therapy slot  with Our App."+" \nYour slot is booked on "+bookingdate+" at "+slottime+" for "+typeofservices);
        System.out.println("Sending");
        javaMailSender.send(message);
        return true;
    }
     
}