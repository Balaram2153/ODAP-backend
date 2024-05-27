package com.doctorappointment.service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.stereotype.Service;
import com.doctorappointment.entity.TreatmentEntity;
import com.doctorappointment.repository.TreatmentRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

	@Service
	public class TreatmentServiceImpl implements TreatmentService{

	    @Autowired
	    private TreatmentRepository treatrepo;

	    @Value("${spring.mail.username}")
	    private String senderEmail;
	   

	    public void saveFileAndSendEmail(String patientName, String patientEmail, String recommendedTest, String doctorName, LocalDate bookingDate, byte[] fileBytes, String fileName)throws IOException {
	        // Save data in the database
	    
			TreatmentEntity fileEntity = new TreatmentEntity();
			fileEntity.setPatientName(patientName);
			fileEntity.setBookingDate(bookingDate);
			fileEntity.setDoctorName(doctorName);
			fileEntity.setRecommendedTest(recommendedTest);
			fileEntity.setPatientEmail(patientEmail);
			fileEntity.setFile(fileBytes);
			treatrepo.save(fileEntity);

			// Send email with the file attachment
		//	sendEmailWithAttachment(email, "File Attached", "Please find the attached file.", fileBytes, fileName);
	    }
	    
	    @Override
		public List<TreatmentEntity> getalltreatments() {
			
			return treatrepo.findAll();
		}

		@Override
		public List<TreatmentEntity> getbydoctor(String doctorName) {
			// TODO Auto-generated method stub
			return treatrepo.findByDoctorName(doctorName);
		}
	  
	

}
