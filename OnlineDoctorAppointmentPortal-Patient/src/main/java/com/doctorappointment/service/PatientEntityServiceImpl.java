package com.doctorappointment.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.doctorappointment.entity.MobileOtpVerification;
import com.doctorappointment.entity.PatientEntity;
import com.doctorappointment.repository.MobleOtpRepository;
import com.doctorappointment.repository.PatientEntityRepository;
import com.doctorappointment.utils.EmailUtils;

import kong.unirest.Unirest;


@Service
public class PatientEntityServiceImpl implements PatientEntityService {
	


	public static final String FASTAPIKEY = "S4oGJgY1R20MTPEzaDL3wNKIqCkZVUABlWjdpH9nXrtbFOiy5uuFWL9YZMkmJlP7Azsjy6Xo18r2nCid";

    @Autowired
    private PatientEntityRepository patientrepository;

    @Autowired
    private MobleOtpRepository mobileOtpRepository;

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private EmailUtils emailService;
    
    
    

    @Override
    public PatientEntity register(PatientEntity patient) {
        // Generate unique ID
        String uniqueId = generateUniqueId(patient.getPatientName(), patient.getCity(), patient.getState());
        patient.setPatientId(uniqueId);

        PatientEntity savedPatient = patientrepository.save(patient);

        return savedPatient;
    }

    private String generateOTP() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }
    
    public void sendOTP(String numbers, String route) throws Exception {
	
    	

		String apiKey = FASTAPIKEY;
		String variablesValues = generateOTP();

		MobileOtpVerification existPhoneNumber = mobileOtpRepository.findBypatientMobileNumber(numbers)
;

		if (existPhoneNumber == null) {
			MobileOtpVerification otpMessage = new MobileOtpVerification();
			otpMessage.setOtp(variablesValues);
			otpMessage.setIsVerify("Pending");	
			otpMessage.setPatientMobileNumber(numbers);
			mobileOtpRepository.save(otpMessage);
		} else {
			existPhoneNumber.setIsVerify("Pending");	
			existPhoneNumber.setOtp(variablesValues);
			mobileOtpRepository.save(existPhoneNumber);
		}

		kong.unirest.HttpResponse<String> response = Unirest.post("https://www.fast2sms.com/dev/bulkV2").header("authorization", apiKey)
				.header("Content-Type", "application/x-www-form-urlencoded")
				.body("variables_values=" + variablesValues + "&route=" + route + "&numbers=" + numbers).asString();

		System.out.println(response.getBody());
	}

    @Override
    public PatientEntity getPatient(String patientId) {
        return patientrepository.findById(patientId).orElse(null);
    }

    @Override
    public void deletePatient(String patientId) {
        patientrepository.deleteById(patientId);
    }

    @Override
    public List<PatientEntity> getallpatients() {
        return patientrepository.findAll();
    }

    @Override
    public boolean sendEmailconfirm(String patientEmail, String patientId) {
        System.out.println("entered");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(patientEmail);
        message.setSubject("Registration successful");
        message.setText("Your patientId is " + patientId + ",\n\nThank you for registering our website.");
        System.out.println("Sending");
        javaMailSender.send(message);
        return true;
    }

    private String generateUniqueId(String patientName, String city, String state) {
        char firstLetterOfName = patientName.charAt(0);
        char firstLetterOfCity = city.charAt(0);
        char firstLetterOfState = state.charAt(0);

        String randomNumbers = String.valueOf(new Random().nextInt(9000) + 1000);

        return String.format("%c%c%c%s", firstLetterOfName, firstLetterOfCity, firstLetterOfState, randomNumbers);
    }

    @Override
    public boolean doesEmailExist(String patientEmail) {
        return patientrepository.existsByPatientEmail(patientEmail);
    }

    @Override
    public void updatepatient(String patientId, PatientEntity patient) {
        Optional<PatientEntity> custo = patientrepository.findById(patientId);
        if (custo.isPresent()) {
            custo.get().setPassword(patient.getPassword());
            custo.get().setConfirmPassword(patient.getConfirmPassword());
            patientrepository.save(custo.get());
        } else {
            System.out.println("no Id found");
        }
    }

	@Override
	public String verifyOTP(String phoneNumber, String enteredOTP) {
		
		MobileOtpVerification numberAndOtp = mobileOtpRepository.findByPatientMobileNumberAndOtp(phoneNumber, enteredOTP);
		
		if(numberAndOtp!=null) {
			numberAndOtp.setIsVerify("success");
			return "Verified";
		}
		return "Fail to verify otp";
	}
}
