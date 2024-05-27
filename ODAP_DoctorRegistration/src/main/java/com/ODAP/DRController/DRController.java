package com.ODAP.DRController;

import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ODAP.DREntity.DREntity;
import com.ODAP.DREntity.WeeklyUpdate;
import com.ODAP.DRRepository.DRRepository;
import com.ODAP.DRRepository.WeeklyUpdateRepo;
import com.ODAP.DRService.DRService;
import com.ODAP.DRService.DRServiceimpl;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DRController {

    @Autowired
    private DRService drservice;

    @Autowired
    private DRRepository drrepository;

    @Autowired
    private WeeklyUpdateRepo weekrepo;
    
    @Autowired
    private DRServiceimpl serviceimpl;
    
    @Autowired
    private DRRepository drrepo;
    
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/sendPhoneotp")
    public String sendOTP(@RequestParam String phoneNumber, @RequestParam String route) {
        if (phoneNumber.length() != 10) {
            return "Fail to send otp";
        }
        try {
            serviceimpl.sendOTP(phoneNumber, route);
            return "sent successfully";
        } catch (Exception e) {
            return "failed to send otp";
        }
    }

    @PostMapping("/verifyPhoneOtp")
    public ResponseEntity<String> verifyPhoneOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
        String verifyOtp = serviceimpl.verifyOTP(phoneNumber, otp);
        return ResponseEntity.status(HttpStatus.OK).body(verifyOtp);
    }

    @PostMapping("/DRData")
    public ResponseEntity<String> saveDoctorRegisterEntity(@RequestBody DREntity doctorregisterentity) {
        String status = drservice.saveRegistration(doctorregisterentity);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @GetMapping("/getdata")
    public ResponseEntity<List<DREntity>> getdata() {
        return new ResponseEntity<>(drrepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/Msdata/{doctorId}")
    public ResponseEntity<DREntity> getMsdata(@PathVariable String doctorId) {
        Optional<DREntity> msentity = drrepository.findById(doctorId);
        return msentity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getname/{doctorName}")
    public List<DREntity> getbydoctor(@PathVariable String doctorName) {
        return drrepository.findByDoctorName(doctorName);
    }

    @PutMapping("/drdata/{doctorId}")
    public ResponseEntity<String> updatePatient(@PathVariable String doctorId, @RequestBody DREntity patient) {
        try {
            Optional<DREntity> existingPatientOpt = drrepo.findById(doctorId);
            if (existingPatientOpt.isPresent()) {
                DREntity existingPatient = existingPatientOpt.get();
                existingPatient.setDoctorName(patient.getDoctorName());
                existingPatient.setEmail(patient.getEmail());
                existingPatient.setSpeciality(patient.getSpeciality());
                existingPatient.setCurrentworkplace(patient.getCurrentworkplace());
                existingPatient.setWebLink(patient.getWebLink());
                existingPatient.setPhonenumber(patient.getPhonenumber());
                existingPatient.setDegree(patient.getDegree());
                existingPatient.setExperience(patient.getExperience());
                drrepo.save(existingPatient);
                return ResponseEntity.ok("Patient details updated successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update patient details");
        }
    }

    @GetMapping("/getAll")
    public List<DREntity> getAll() {
        return drrepository.findAll();
    }

    @DeleteMapping("/Msdata/{id}")
    public ResponseEntity<Void> deleteMsdata(@PathVariable String id) {
        Optional<DREntity> msentity = drrepository.findById(id);
        if (msentity.isPresent()) {
            drrepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getSpecility/{specility}")
    public List<DREntity> getSpecility(@PathVariable String specility) {
        return drrepository.findAllBySpeciality(specility);
    }

    @GetMapping("/doctors/search")
    public List<DREntity> searchDoctorsBySpeciality(@RequestParam String speciality) {
        return drrepository.findBySpecialityContainingIgnoreCase(speciality);
    }

    @PostMapping("/weeklySlotDates")
    public WeeklyUpdate addWeeklySlotDates(@RequestBody WeeklyUpdate slotDates) {
        return drservice.saveWeeklyUpdates(slotDates);
    }

    @GetMapping("/weeklySlotDates/{doctorId}")
    public WeeklyUpdate getweeklySlotDates(@PathVariable String doctorId) {
        return drservice.getWeeklyUpdateById(doctorId);
    }

    @PostMapping("/passwordreset/{email}")
    public ResponseEntity<String> otpForPasswordReset(@PathVariable String email) {
        try {
            DREntity doc = drrepository.findByEmail(email);
            if (doc != null) {
                String OTP = randomOTPForPassword();
                doc.setEmailOtp(OTP);
                drrepository.save(doc);
                sendEmail(email, OTP);
                return ResponseEntity.ok("OTP sent to the registered email");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    private String randomOTPForPassword() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    private void sendEmail(String email, String emailOtp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP Verification");
        message.setText("Your OTP for password reset is: " + emailOtp);
        javaMailSender.send(message);
    }

    @PostMapping("/verifyotpfornewpassword/{email}/{enteredOtp}/{newPassword}")
    public ResponseEntity<String> verifyOTPForNewPassword(@PathVariable String email, @PathVariable String enteredOtp, @PathVariable String newPassword) {
        try {
            DREntity doc = drrepository.findByEmail(email);
            if (doc != null && doc.getEmailOtp() != null && doc.getEmailOtp().equals(enteredOtp)) {
                doc.setPassword(newPassword);
                doc.setConfirmPassword(newPassword);
                doc.setEmailOtp(null);
                drrepository.save(doc);
                return ResponseEntity.ok("Password reset successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Check your credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
}
