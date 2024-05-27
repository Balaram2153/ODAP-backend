package com.ODAP.DRService;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ODAP.DREntity.DREntity;
import com.ODAP.DREntity.MobileDR;
import com.ODAP.DREntity.WeeklyUpdate;
import com.ODAP.DRRepository.DRRepository;
import com.ODAP.DRRepository.WeeklyUpdateRepo;
import com.ODAP.DRRepository.mobileDRRepository;

import kong.unirest.Unirest;

@Service
public class DRServiceimpl implements DRService {

	@Autowired
	private DRRepository drrepo;

	@Autowired
	private WeeklyUpdateRepo weeklyRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private mobileDRRepository mobileDRRepo;

	public static final String FASTAPIKEY = "S4oGJgY1R20MTPEzaDL3wNKIqCkZVUABlWjdpH9nXrtbFOiy5uuFWL9YZMkmJlP7Azsjy6Xo18r2nCid";

	@Override
	public String saveRegistration(DREntity doctor) {

		String uniqueId = generateUniqueId(doctor.getDoctorName(), doctor.getHospitalName(),
				doctor.getCurrentworkplace());
		DREntity existingDoctor = drrepo.findByEmail(doctor.getEmail());
		if (existingDoctor != null) {
			return "Duplicate Email";
		}

		// Set the generated ID to the user
		doctor.setDoctorId(uniqueId);
		// patient.setPatientId(generateUniqueID(patient.getPatientName(),patient.getCity(),
		// patient.getState()));
		DREntity save = drrepo.save(doctor);
		sendEmailconfirm(save.getEmail(), save.getDoctorId());

		return "registration done";
	}

	private String generateUniqueId(String doctorName, String hospitalName, String currentWorkplace) {
		// TODO Auto-generated method stub
		// Get the first letter of each field
		char firstLetterOfName = doctorName.charAt(0);
		char firstLetterOfCity = hospitalName.charAt(0);
		char firstLetterOfState = currentWorkplace.charAt(0);

		// Generate random numbers (you can customize this logic)
		String randomNumbers = String.valueOf(new Random().nextInt(9000) + 1000);

		// Combine the letters and random numbers to create the unique ID
		return String.format("%c%c%c%s", firstLetterOfName, firstLetterOfCity, firstLetterOfState, randomNumbers);
	}

	@Override
	public List<DREntity> getbydoctor(String doctorName) {
		// TODO Auto-generated method stub
		return drrepo.findByDoctorName(doctorName);
	}

	@Override
	public WeeklyUpdate saveWeeklyUpdates(WeeklyUpdate weeklyUpdate) {

		return weeklyRepo.save(weeklyUpdate);

	}

	@Override
	public boolean sendEmailconfirm(String email, String doctorId) {
		System.out.println("entered");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Registration successful");
		message.setText("Your Doctor ID is " + doctorId + ",\n\nThank you for registering our website.");
		System.out.println("Sending");
		javaMailSender.send(message);
		return true;
	}

	@Override
	public WeeklyUpdate getWeeklyUpdateById(String doctorId) {
		Optional<WeeklyUpdate> findById = weeklyRepo.findByDoctorId(doctorId);
		if (findById.isPresent()) {
			WeeklyUpdate update = findById.get();
			return update;
		} else
			throw new RuntimeException("Weekly Update Not Found Fot this Id");
	}

	private String generateOTP() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));
	}

	public void sendOTP(String numbers, String route) throws Exception {

		String apiKey = FASTAPIKEY;
		String variablesValues = generateOTP();

		MobileDR existPhoneNumber = mobileDRRepo.findByPhoneNumber(numbers);

		if (existPhoneNumber == null) {
			MobileDR otpMessage = new MobileDR();
			otpMessage.setOtp(variablesValues);
			otpMessage.setIsVerify("Pending");
			otpMessage.setPhoneNumber(numbers);
			mobileDRRepo.save(otpMessage);
		} else {
			existPhoneNumber.setIsVerify("Pending");
			existPhoneNumber.setOtp(variablesValues);
			mobileDRRepo.save(existPhoneNumber);
		}
		kong.unirest.HttpResponse<String> response = Unirest.post("https://www.fast2sms.com/dev/bulkV2")
				.header("authorization", apiKey).header("Content-Type", "application/x-www-form-urlencoded")
				.body("variables_values=" + variablesValues + "&route=" + route + "&numbers=" + numbers).asString();
		System.out.println(response.getBody());

	}

	@Override
	public String verifyOTP(String phoneNumber, String enteredOTP) {

		MobileDR numberAndOtp = mobileDRRepo.findByPhoneNumberAndOtp(phoneNumber, enteredOTP);

		if (numberAndOtp != null) {
			numberAndOtp.setIsVerify("success");
			return "Verified";
		}
		return "Fail to verify otp";
	}

}
