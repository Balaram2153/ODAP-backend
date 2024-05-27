package com.doctorappointment.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorappointment.entity.PatientEntity;
import com.doctorappointment.repository.PatientEntityRepository;
import com.doctorappointment.service.PatientEntityService;
import com.doctorappointment.service.PatientEntityServiceImpl;
import com.doctorappointment.utils.EmailUtils;

@RestController
@CrossOrigin("*")

public class PatientEntityController {

	@Autowired
	private PatientEntityService patientservice;

	@Autowired
	private EmailUtils emailService;

	@Autowired
	private PatientEntityRepository patientrepository;

	@Autowired
	private PatientEntityServiceImpl serviceimpl;

//	@Autowired
//	private MobileOtpVerificationRepository mobileOtpRepository;

	@PostMapping("/patient/register")
	public PatientEntity register(@RequestBody PatientEntity patient) {
		emailService.sendEmailconfirm(patient.getPatientEmail(), patient.getPatientName(), patient.getPatientId());

		return patientservice.register(patient);

	}

	@PostMapping("/sendPhoneotp")
	public String sendOTP(@RequestParam String patientMobileNumber, @RequestParam String route) {
		if (patientMobileNumber.length() != 10) {
			return "Fail to send otp";
		}
		try {
			System.out.println("try");
			serviceimpl.sendOTP(patientMobileNumber, route);
			return "sent successfully";
		} catch (Exception e) {
			return "failed to send otp";
		}
	}

	@PostMapping("/verifyPhoneOtp")
	public ResponseEntity<String> verifyPhoneOtp(@RequestParam String patientMobileNumber, @RequestParam String otp) {
		String verifyOtp = serviceimpl.verifyOTP(patientMobileNumber, otp);
		return ResponseEntity.status(HttpStatus.OK).body(verifyOtp);
	}

	@PostMapping("/send-email")
	public ResponseEntity<String> send(@RequestParam String patientEmail, @RequestParam String patientId) {
		try {
			// PatientEntity patient=new PatientEntity();
			System.out.println("Entered controller");
			boolean sendEmail = patientservice.sendEmailconfirm(patientEmail, patientId);
			// sendEmailconfirm(patient.getEmail(), patient.getPatientId());
			if (sendEmail) {
				return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully");
			} else {
				return null;
			}

		} catch (Exception e) {
			// Log the exception or handle it accordingly
			System.out.println(e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
		}
	}

	@GetMapping("/exist/{email}")
	public ResponseEntity<String> checkEmailExists(@PathVariable String patientEmail) {
		boolean emailExists = patientservice.doesEmailExist(patientEmail);

		if (emailExists) {
			return ResponseEntity.ok("Email exists");
		} else {
			return ResponseEntity.ok("Email does not exist");
		}
	}

	@GetMapping("/getall/patients")
	public List<PatientEntity> getallpatients() {
		return patientservice.getallpatients();
	}

	@PutMapping("/api/register/{patientId}")
	public ResponseEntity<?> updatePatient(@PathVariable String patientId, @RequestBody PatientEntity patient) {
		try {
			PatientEntity existingPatient = patientrepository.findById(patientId).orElse(null);
			if (existingPatient == null) {
				return ResponseEntity.notFound().build();
			}

			existingPatient.setPatientName(patient.getPatientName());
			existingPatient.setPatientEmail(patient.getPatientEmail());
			existingPatient.setPatientMobileNumber(patient.getPatientMobileNumber());
			existingPatient.setCity(patient.getCity());
			existingPatient.setState(patient.getState());
			existingPatient.setPincode(patient.getPincode());

			patientrepository.save(existingPatient);

			return ResponseEntity.ok().body("Patient details updated successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update patient details");
		}
	}

	@PostMapping("/getotp/{patientEmail}")
	public void saveOTP(@PathVariable String patientEmail) {
		PatientEntity patient = patientrepository.findByPatientEmail(patientEmail);
		if (patient != null) {

			String OTP = generateRandomOTP();
			patient.setOtp(OTP);

			sendEmail(patientEmail, OTP);

			patientrepository.save(patient);

		}
	}

	private String generateRandomOTP() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));
	}

	@Autowired
	private JavaMailSender javaMailSender1;

	private void sendEmail(String patientEmail, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(patientEmail);
		message.setSubject("OTP Verification");
		message.setText("Your OTP for verification is: " + otp);
		javaMailSender1.send(message);
	}

	@PostMapping("/verify/{patientEmail}/{enteredOTP}")
	public boolean verifyOTP(@PathVariable String patientEmail, @PathVariable String enteredOTP) {
		PatientEntity patient = patientrepository.findByPatientEmail(patientEmail);
		return patient != null && patient.getOtp() != null && patient.getOtp().equals(enteredOTP);
	}

	@GetMapping("/get/{patientId}")
	public PatientEntity getpatient(@PathVariable String patientId) {
		return patientservice.getPatient(patientId);
	}

	@DeleteMapping("/api/delete/{patientId}")
	public void deletepatient(@PathVariable String patientId) {

		patientservice.deletePatient(patientId);
	}

}
