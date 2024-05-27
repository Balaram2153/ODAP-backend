package com.example.online.Doctor.Portal.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.online.Doctor.Portal.Entity.PatientReport;
import com.example.online.Doctor.Portal.Entity.Registration;
import com.example.online.Doctor.Portal.Entity.Reports;
import com.example.online.Doctor.Portal.Repositary.PatientReportsRepo;
import com.example.online.Doctor.Portal.Repositary.RegistrationRepo;
import com.example.online.Doctor.Portal.Repositary.ReportRepo;
import com.example.online.Doctor.Portal.Service.Emailservice;
import com.example.online.Doctor.Portal.Service.TechnicianService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@CrossOrigin("*")
@RequestMapping("/Registration")
public class RegistrationController {

    @Autowired
    private TechnicianService service;
    
    @Autowired
    RegistrationRepo registrationrepo;
    

	@Autowired
	private Emailservice emailService;
	
	@Autowired
	private TechnicianService technicianservice;
	
	@Autowired
    private ReportRepo reportrepo;
	
	@Autowired 
	private PatientReportsRepo patientreportrepo;

   @PostMapping("/savereport")
    public Reports saveReports(@RequestBody Reports report) {
    	return reportrepo.save(report);
    }

    @PostMapping("/saveT")
    public ResponseEntity<?> saveRegistration(@RequestBody Registration technician) {
		
	
		 String status = service.saveRegistration(technician);
			emailService.sendEmailconfirm(technician.getEmail(), technician.getTechnicianname(), technician.getTechnicianId());


    return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    
    @PostMapping("/upload")
    public Reports handleFileUpload(
            @RequestParam("patientName") String patientName,
            @RequestParam("attendeddoctor") String attendeddoctor,
            @RequestParam("testtype") String testtype,
            @RequestParam("doctorEmail") String doctorEmail,
            @RequestParam("patientEmail") String patientEmail,
            @RequestParam("file") MultipartFile file,
            @RequestParam("reports") String reports,
            @RequestParam("doctorName") String doctorName,

            @RequestParam("diagnosticCenter")String diagnosticCenter) throws IOException, MessagingException {
        
    	Reports fileEntity = new Reports();
            fileEntity.setPatientName(patientName);
            fileEntity.setAttendeddoctor(attendeddoctor);
            fileEntity.setTesttype(testtype);
            fileEntity.setDoctorEmail(doctorEmail);
            fileEntity.setDoctorName(doctorName);
            fileEntity.setPatientEmail(patientEmail);
            fileEntity.setFile(file.getBytes());
            fileEntity.setReports(reports);
            fileEntity.setDiagnosticCenter(diagnosticCenter);
          

          return reportrepo.save(fileEntity);
           
		

    }
	
    @PostMapping("/uploadReport")
    public PatientReport handleReportUpload(
    		
    	
    		
            @RequestParam("patientName") String patientName,
            @RequestParam("referralDoctorName") String referralDoctorName,
            @RequestParam("typeofservices") String typeofservices,
            @RequestParam("appointmentRefId") String appointmentRefId,
            @RequestParam("tests") String tests,
            @RequestParam("doctorEmail") String doctorEmail,
            @RequestParam("patientEmail") String patientEmail,
            @RequestParam("file") MultipartFile file,
            @RequestParam("reports") String reports,
            @RequestParam("doctorName") String doctorName,

            @RequestParam("diagnosticCenter")String diagnosticCenter) throws IOException, MessagingException {
        
    	PatientReport fileEntity = new PatientReport();
            fileEntity.setPatientName(patientName);
            fileEntity.setReferralDoctorName(referralDoctorName);
            fileEntity.setTypeofservices(typeofservices);
            fileEntity.setDoctorEmail(doctorEmail);
            fileEntity.setAppointmentRefId(appointmentRefId);
            fileEntity.setTests(tests);
            fileEntity.setDoctorName(doctorName);
            fileEntity.setPatientEmail(patientEmail);
            fileEntity.setFile(file.getBytes());
            fileEntity.setReports(reports);
            fileEntity.setDiagnosticCenter(diagnosticCenter);
          

        return patientreportrepo.save(fileEntity);
           
		

    } 
    

    
    @PostMapping("/passwordreset/{email}")
	public ResponseEntity<String> otpForPasswordReset(@PathVariable String email) {
		
		try {
			Registration tec = registrationrepo.findByEmail(email);
			if (tec != null) {

				//empEnt.setPassword(newPassword);

				//empEnt.setNewPassword(null);

				String OTP = randomOTPForPassword();
				tec.setEmailOtp(OTP);

				sendEmail(email, OTP);

				registrationrepo.save(tec);

				return ResponseEntity.ok("otp sent to the registered email");	

			
		} 
		}catch (Exception e) {
			e.printStackTrace();
			
		
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no email found");				
		
	
	}

	private String randomOTPForPassword() {
		Random random = new Random();
		return String.format("%06d", random.nextInt(10000));
	}
	


	private void sendEmail(String email, String emailOtp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP Verification");
		message.setText("Your OTP for passwordReset is: " + emailOtp);
		javaMailSender1.send(message);
	}

	@PostMapping("/verifyotpfornewpassword/{email}/{enteredOtp}/{newPassword}/{confirmpassword}")
	public ResponseEntity<String> verifyOTPForNewPassword(@PathVariable String email, @PathVariable String enteredOtp, @PathVariable String newPassword) {
		
try {
	Registration tech = registrationrepo.findByEmail(email);
	if (tech != null && tech.getEmailOtp() != null
			&& tech.getEmailOtp().equals(enteredOtp) ) {
		
		tech.setPassword(newPassword);
		tech.setConfirmpassword(newPassword);
		tech.setEmailOtp(null);
		registrationrepo.save(tech);
		return ResponseEntity.ok("password Reset succesfully");
	} 

	
} catch (Exception e) {
	e.printStackTrace();
}
 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("check your credentials");		
		
	}
    
    
    
    
    
	
	@GetMapping("/getdoctor/{doctorName}")
	public List<Reports>doctor(@PathVariable String doctorName)
	{
		return reportrepo.findByDoctorName(doctorName);
	}
	
	@GetMapping("/Tdata")
	public ResponseEntity<List<Registration>> getdata(){
		return new ResponseEntity<>(registrationrepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/getemail/{email}")
	public ResponseEntity<Registration> getRegistrationByEmail(@PathVariable String email) {
	    System.out.println("Searching for email: " + email);
	    Registration registration = registrationrepo.findByEmail(email);
	    if (registration != null) {
	        System.out.println("Email found: " + registration.getEmail());
	        return new ResponseEntity<>(registration, HttpStatus.OK);
	    } else {
	        System.out.println("Email not found");
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


	
	@GetMapping("/Tdata/{technicianId}")
	public ResponseEntity<Registration> getMsdata(@PathVariable String technicianId){
		Optional<Registration> msentity = registrationrepo.findById(technicianId);
		if(msentity.isPresent()) {
			return new ResponseEntity<>(msentity.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getcenter/{diagnosticCenter}")
	public List<Registration> getcenters(@PathVariable String diagnosticCenter){
		return registrationrepo.findByDiagnosticCenter(diagnosticCenter);
	}
	
	 @Autowired
	 private JavaMailSender javaMailSender1;
	 
	    @PostMapping("/sentpdfemail")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> sendEmailWithFile(@RequestParam("file") MultipartFile file, @RequestParam("doctorEmail") String doctorEmail)
	            throws MessagingException, IOException {

	        // Attach the uploaded file to the email
	        MimeMessage mimeMessage = javaMailSender1.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	        helper.setTo(doctorEmail);
	        helper.setSubject("PDF Attachment");
	        helper.setText("Please find the attached PDF.");

	        // Specify the uploaded file
helper.addAttachment(Objects.requireNonNull(file.getOriginalFilename()), file::getInputStream);

	        // Send the email
	        javaMailSender1.send(mimeMessage);

	        return ResponseEntity.ok("prescription sent to email successfully");
	    }
	
	    
		 @Autowired
		    private JavaMailSender javaMailSender;

		    @PostMapping("/sentreportemail")
		    @ResponseStatus(HttpStatus.OK)
		    public ResponseEntity<String> sendPdfEmailWithFile(@RequestParam("file") MultipartFile file, @RequestParam("patientEmail") String patientEmail)
		         
		    	throws MessagingException, IOException {

		        // Attach the uploaded file to the email
		        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
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
		    
		    @PutMapping("/api/register/{technicianId}")
		    public ResponseEntity<?> updateTechnician(@PathVariable String technicianId, @RequestBody Registration technician) {
		        try {
		            Optional<Registration> existingTechnicianOptional = registrationrepo.findById(technicianId);
		            
		            if (existingTechnicianOptional.isPresent()) {
		                Registration existingTechnician = existingTechnicianOptional.get();

		                existingTechnician.setTechnicianname(technician.getTechnicianname());
		                existingTechnician.setTechnicianstudy(technician.getTechnicianstudy());
		                existingTechnician.setMobilenumber(technician.getMobilenumber());
		                existingTechnician.setDiagnosticaddress(technician.getDiagnosticaddress());
		                existingTechnician.setDiagnosticCenter(technician.getDiagnosticCenter());
		                existingTechnician.setEmail(technician.getEmail());
		                existingTechnician.setTypeofservices(technician.getTypeofservices());

		                registrationrepo.save(existingTechnician);

		                return ResponseEntity.ok().body("Technician details updated successfully");
		            } else {
		                return ResponseEntity.notFound().build();
		            }
		        } catch (Exception e) {
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update technician details");
		        }
		    }

		
	
	
}

