package Patient.Book.Test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import Patient.Book.Test.Dto.LoginRequest;
import Patient.Book.Test.ExceptionHandlers.CustomException;
import Patient.Book.Test.ExceptionHandlers.PatientNotFoundException;
import Patient.Book.Test.Repositary.PatientRepository;
import Patient.Book.Test.Services.EmailService;
import Patient.Book.Test.Services.PatientService;
import Patient.Book.Test.Services.PaymentService;
import Patient.Book.Test.enity.Patient;
import Patient.Book.Test.enity.PaymentDetails;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private  PaymentService paymentService;
    
    @Autowired
    private PatientRepository patientrepo;
    
    @Autowired
    private EmailService emailService;
    
    @PostMapping("/payment")
    public ResponseEntity<Object> savePayment(@RequestParam("patientName") String patientName,
                                              @RequestParam("tests") String tests,
                                              @RequestParam("chronicDisease") String chronicDisease,
                                              @RequestParam("typeofservices") String typeofservices,
                                              @RequestParam("bookingDate") LocalDate bookingDate,
                                              @RequestParam("bookingTime") LocalTime bookingTime,
                                              @RequestParam("addressLine1") String addressLine1,
                                              @RequestParam("address") String address,
                                              @RequestParam("referralDoctorName") String referralDoctorName,
                                              @RequestParam("diagnosticCenter") String diagnosticCenter,
                                              @RequestParam("gender") String gender,
                                              @RequestParam("age") int age,
                                              @RequestParam("amount") String amount,
                                              @RequestParam("collection") String collection,
                                              @RequestParam("prescription") MultipartFile prescription,
                                              @RequestParam("patientEmail") String patientEmail,
                                              @RequestParam("patientMobileNumber") String patientMobileNumber,
                                              @RequestParam("modeOfPayment") String modeOfPayment) {
    	
    	
    	
    	
    	try {
            byte[] prescriptionBytes = prescription.getBytes();
            System.out.println(gender+address);
            PaymentDetails payment= new PaymentDetails(patientName,tests,chronicDisease,typeofservices,bookingDate,bookingTime,addressLine1,address,referralDoctorName,diagnosticCenter,gender,age,amount,collection,patientEmail,patientMobileNumber,prescriptionBytes,modeOfPayment);
            
            
            PaymentDetails createdPatient = paymentService.savePaymentDetails(payment);
            return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Error occurred while processing prescription file", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    
 
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Patient patient = null;

            // Check if email is provided
            if (loginRequest.getEmail() != null) {
                patient = patientService.getPatientByEmail(loginRequest.getEmail())
                            .orElse(null);
                if (patient == null) {
                    throw new PatientNotFoundException("Patient not found with provided email.");
                }
            }

            // Check if mobile number is provided
            if (loginRequest.getMobileNumber() != null && patient == null) {
                patient = patientService.getPatientByMobileNumber(loginRequest.getMobileNumber())
                            .orElse(null);
                if (patient == null) {
                    throw new PatientNotFoundException("Patient not found with provided mobile number.");
                }
            }

            if (patient != null) {
                // You can add additional checks here, such as verifying password
                return ResponseEntity.ok(patient); // Return the patient object to frontend
            } else {
                throw new PatientNotFoundException("Patient not found with provided email or mobile number.");
            }
        } catch (PatientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPatient(@RequestParam("appointmentRefId") String appointmentRefId,
    		                                    @RequestParam("patientId") String patientId,
    											@RequestParam("patientName") String patientName,
                                                @RequestParam("tests") String tests,
                                                @RequestParam("chronicDisease") String chronicDisease,
                                                @RequestParam("bookingDate") LocalDate bookingDate,
                                                @RequestParam("bookingTime") LocalTime bookingTime,
                                                @RequestParam("address") String address,
                                                @RequestParam("typeofservices")String typeofservices,
                                                @RequestParam("addressLine1") String addressLine1,
                                                @RequestParam("referralDoctorName") String referralDoctorName,
                                                @RequestParam("diagnosticCenter") String diagnosticCenter,
                                                @RequestParam("gender") String gender,
                                                @RequestParam("age") int age,
                                                @RequestParam("amount") String amount,
                                                @RequestParam("collection") String collection,
                                                @RequestParam("prescription") MultipartFile prescription,
                                                @RequestParam("patientEmail") String patientEmail,
                                                @RequestParam("patientMobileNumber") String patientMobileNumber
                                                
                                                ) {
    	 try {
             byte[] prescriptionBytes = prescription.getBytes();
             Patient patient = new Patient(appointmentRefId,patientId,patientName, tests, chronicDisease, typeofservices,
                     bookingDate, bookingTime, address, addressLine1, referralDoctorName,
                     diagnosticCenter, gender, age, amount, collection, prescriptionBytes,
                     patientEmail, patientMobileNumber);

             Patient createdPatient = patientService.createPatient(patient);
             return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
         }catch (IOException | CustomException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{appointmentRefId}")
    public ResponseEntity<Object> getPatientById(@PathVariable long id) {
        try {
            Optional<Patient> patient = patientService.getPatientById(id);
            if (patient.isPresent()) {
                return new ResponseEntity<>(patient.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
            }
        } catch (CustomException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PutMapping("/{appointmentRefId}")
//    public ResponseEntity<Object> updatePatient(@PathVariable String appointmentRefId, @RequestBody Patient patient) {
//        try {
//            Patient updatedPatient = patientService.updatePatient(appointmentRefId, patient);
//            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
//        } catch (CustomException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @DeleteMapping("/{appointmentRefId}")
//    public ResponseEntity<Object> deletePatient(@PathVariable String appointmentRefId) {
//        try {
//            patientService.deletePatient(appointmentRefId);
//            return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
//        } catch (CustomException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    
    

    @GetMapping("/getpayments")
    public List<PaymentDetails> getallpayments()
    {
		return paymentService.getallpayments();
    	
    }
    
    @GetMapping("/getname/{patientName}")
    public List<Patient> getallnames(@PathVariable String patientName)
    {
		return patientrepo.findByPatientName(patientName);
		
    	
    }
    
    @GetMapping("/getpatients/{patientId}")
    public List<Patient> getallpatientnames(@PathVariable String patientId)
    {
		return patientrepo.findByPatientId(patientId);
		
    	
    }
    
    
    @GetMapping("/getdiagnostic/{diagnosticCenter}")
    public List<Patient> getalldiagnostics(@PathVariable String diagnosticCenter) 
    {
		return patientService.getalldiagnostics(diagnosticCenter);
    	
		
    }
    @GetMapping("/all")
    public ResponseEntity<Object> getAllPatients() {
        try {
            List<Patient> patients = patientService.getAllPatients();
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


