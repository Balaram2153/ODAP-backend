package com.ODAP.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.ODAP.Entity.MSEntity;
import com.ODAP.Entity.MedicalPayment;
import com.ODAP.Entity.Report;
import com.ODAP.Repositery.MSRepositery;
import com.ODAP.Repositery.MedicalPaymentRepo;
import com.ODAP.Repositery.Repostrepo;
import com.ODAP.Service.EmailService;
import com.ODAP.Service.MSService;
import com.ODAP.Service.MedicalPaymentService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class MSController {
	
	@Autowired
	MSRepositery msrepositery;

	
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Repostrepo reportrepo;
	
	@Autowired
	private MedicalPaymentRepo paymentrepo;
	
	@Autowired
	private MSService msservice;
	
	@Autowired
	private MedicalPaymentService paymentservice;
	
	

	
	@PostMapping("/Report")
	public ResponseEntity<Report> saveReport(@RequestBody Report report){
		return new ResponseEntity<>(reportrepo.save(report),HttpStatus.CREATED);
	}
	
	@PostMapping("/Msdata")
	public MSEntity saveMSEntity(@RequestBody MSEntity msentity) {
		return msservice.saveMSEntity(msentity);
 
	}
	
	
	
//	
//	@PostMapping("/paymentsave")
//	public PaymentMedical savePayment(PaymentMedical payment)
//	
//	{
//		return msservice.savePayment(payment);
//		
//	}


	 
	@GetMapping("/Msdata")
	public ResponseEntity<List<MSEntity>> getdata(){
		return new ResponseEntity<>(msrepositery.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/Msdata/{medicalid}")
	public ResponseEntity<MSEntity> getMsdata(@PathVariable String medicalid){
		Optional<MSEntity> msentity = msrepositery.findById(medicalid);
		if(msentity.isPresent()) {
			return new ResponseEntity<>(msentity.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getbynames/{patientName}")
	public List<MSEntity>getname(@PathVariable String patientName)
	{
		return msrepositery.findByPatientName(patientName);
	}
	
	@GetMapping("/getbynamepatient/{patientId}")
	public List<MSEntity>getnamepatient(@PathVariable String patientId)
	{
		return msrepositery.findByPatientId(patientId);
	}
	
	@GetMapping("/getname/{typeofservices}")
	public List<MSEntity>getbytypeofservices(@PathVariable String typeofservices) {

		return msrepositery.findByTypeofservices(typeofservices);
	}
	
	
	
	@GetMapping("/medical/getall")
	public List<MedicalPayment> getAllPayments() {
        return paymentrepo.findAll();
    }

//    public Optional<PaymentMedical> getPaymentById(String paymentid) {
//        return paymentrepo.findById(paymentid);
//    }


	@PostMapping("/medicalpay")
	public MedicalPayment pay(@RequestBody MedicalPayment payment) {
		return paymentservice.pay(payment);
    }
	
	
	 

	


//    public PaymentMedical updatePayment(String paymentid, PaymentMedical updatedPayment) {
//        updatedPayment.setPaymentid(paymentid); // Set the ID of the updated payment
//        return paymentrepo.save(updatedPayment);
//    }

    
	
//	@PostMapping("/Payment")
//	public ResponseEntity<PaymentMedical> saveReport(@RequestBody PaymentMedical payment){
//		return new ResponseEntity<>(paymentrepo.save(payment),HttpStatus.CREATED);
//	}
//	
//    @PostMapping("/send-email")
//    public ResponseEntity<String> sendEmail(@RequestBody Emailconfirm emailconfirm) {
//        try {
//        	System.out.println("Entered controller"+emailconfirm.getEmail());
//            boolean sendEmail = emailService.sendEmailconfirm(emailconfirm.getEmail(), emailconfirm.getPatientname(), emailconfirm.getTypeofservices(), emailconfirm.getBookingdate(), emailconfirm.getSlottime());
//            if(sendEmail) {
//            	 return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully");
//            }else {
//            	return null;
//            }
//           
//        } catch (Exception e) {
//            // Log the exception or handle it accordingly
//        	System.out.println(e.toString());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
//        }
//    }
//    
//	@PostMapping("/send-email")
//    public void sendEmail(@RequestBody Emailconfirm emailconfirm) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(emailconfirm.getTo());
//        message.setSubject(emailconfirm.getSubject());
//
//        String mailBody = "Dear" + emailconfirm.getPatientname() + ",\n\n";
//        mailBody += emailconfirm.getBody();
//        mailBody += "\n\n"+emailconfirm.getTypeofservices()+"is booked for you on"+emailconfirm.getBookingdate()+"at"+emailconfirm.getSlottime();
//
//        message.setText(mailBody);
//
//        javaMailSender.send(message);
//    }
    
	
	@DeleteMapping("/Msdata/{medicalid}")
	public ResponseEntity<Void> deleteMsdata(@PathVariable String medicalid){
		Optional<MSEntity> msentity = msrepositery.findById(medicalid);
		if(msentity.isPresent()) {
			msrepositery.deleteById(medicalid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	    
//	    @Autowired
//	    private JavaMailSender javaMailSender2;
//
//	    @PostMapping("/send-email")
//	    public ResponseEntity<String> sendPdfDoctorEmailWithFile(@RequestParam("file") MultipartFile file, @RequestParam("doctorEmail") String doctorEmail)
//	    
//	        throws MessagingException, IOException {
//
//	        // Attach the uploaded file to the email
//	        MimeMessage mimeMessage = javaMailSender2.createMimeMessage();
//	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//	        helper.setTo(doctorEmail);
//	        helper.setSubject("Patient report");
//	        helper.setText("Please find the attached PDF.");
//	        helper.setText("Please review and approve this report so, it cna be sent to the patient.");
//	        
//	        // Specify the uploaded file
//            helper.addAttachment(Objects.requireNonNull(file.getOriginalFilename()), file::getInputStream);
//
//	        // Send the email
//	        javaMailSender2.send(mimeMessage);
//
//	        return ResponseEntity.ok("PDF email sent successfully");
//	    }
	    
	    @Autowired
	    private JavaMailSender javaMailSender1;

	    @PostMapping("/sentpdf")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> sendEmailWithFile(@RequestParam("file") MultipartFile file, String patientEmail)
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
	    
	    
	    
	
//	 @PostMapping("/send-email")
//	    public ResponseEntity<String> sendEmailWithFile(
//	            @RequestParam("email") String email,
//	            @RequestParam("file") MultipartFile file
//	    ) {
//	        System.out.println("Email sent to: " + email);
//			System.out.println("File received: " + file.getOriginalFilename());
//
//			return ResponseEntity.ok("Email sent successfully");
//	    }
//	
	
}
