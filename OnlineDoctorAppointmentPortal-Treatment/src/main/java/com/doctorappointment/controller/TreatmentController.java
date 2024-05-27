package com.doctorappointment.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.doctorappointment.entity.TreatmentEntity;
import com.doctorappointment.repository.TreatmentRepository;
import com.doctorappointment.service.TreatmentServiceImpl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@RestController
@CrossOrigin("*")
public class TreatmentController {
	
	@Autowired
	TreatmentRepository treatrepo;
	
	
	@Autowired
	TreatmentServiceImpl treatser;
	

	 
   
	@PostMapping("/upload")
    public TreatmentEntity handleFileUpload(
            @RequestParam("bookingDate") LocalDate bookingDate,
            @RequestParam("patientName") String patientName,
            @RequestParam("doctorName") String doctorName,
            @RequestParam("patientEmail") String email,
            @RequestParam("file") MultipartFile file,
            @RequestParam("prognosis") String prognosis,
            @RequestParam("temperature") String temperature,
            @RequestParam("treatment")String treatment,
            @RequestParam("spO2")String spO2,
            @RequestParam("bp") String bp,
            @RequestParam("followupDate") Date followupDate,
            @RequestParam("recommendedTest")String recommendedTest,
            @RequestParam("medicineName")String medicineName,
            @RequestParam("medicineType")String medicineType,
            @RequestParam("form")String form,
            @RequestParam("quantity")String quantity,
            @RequestParam("dosageTiming")String dosageTiming    		
    		
    		) throws IOException, MessagingException {
        
            TreatmentEntity fileEntity = new TreatmentEntity();
            fileEntity.setBookingDate(bookingDate);
            fileEntity.setPatientName(patientName);
            fileEntity.setDoctorName(doctorName);
            fileEntity.setBp(bp);
            fileEntity.setFollowupDate(followupDate);
            fileEntity.setRecommendedTest(recommendedTest);
            fileEntity.setPrognosis(prognosis);
            fileEntity.setTemperature(temperature);
            fileEntity.setTreatment(treatment);
            fileEntity.setSpO2(spO2);
            fileEntity.setPatientEmail(patientName);
            fileEntity.setFile(file.getBytes());
            fileEntity.setMedicineName(medicineName);
            fileEntity.setMedicineType(medicineType);
            fileEntity.setForm(form);
            fileEntity.setQuantity(quantity);
            fileEntity.setDosageTiming(dosageTiming);
          

          return treatrepo.save(fileEntity);
           
		

    }
	
	 @Autowired
	    private JavaMailSender javaMailSender1;

	    @PostMapping("/sentemail")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> sendPdfEmailWithFile(@RequestParam("file") MultipartFile file, @RequestParam("patientEmail") String patientEmail)
	            throws MessagingException, IOException {

	        // Attach the uploaded file to the email
	        MimeMessage mimeMessage = javaMailSender1.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	        helper.setTo(patientEmail);
	        helper.setSubject("PDF Attachment");
	        helper.setText("Please find the attached PDF.");

	        // Specify the uploaded file
   helper.addAttachment(Objects.requireNonNull(file.getOriginalFilename()), file::getInputStream);

	        // Send the email
	        javaMailSender1.send(mimeMessage);

	        return ResponseEntity.ok("prescription sent to email successfully");
	    }
	    
	    
	    @GetMapping("/name/{doctorName}")
		public List<TreatmentEntity> getbydoctor(@PathVariable String doctorName) {
			
			return treatser.getbydoctor(doctorName);
		}

	    
	@GetMapping("/getalltreat")
	public List<TreatmentEntity> getalltreatments()
	{
		return treatser.getalltreatments();
	}
	


}
