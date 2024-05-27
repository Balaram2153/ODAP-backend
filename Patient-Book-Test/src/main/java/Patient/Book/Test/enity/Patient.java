package Patient.Book.Test.enity;



import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Patient {

    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String appointmentRefId;
    private String patientId; 
    private String patientName;
    private String tests;
    private String chronicDisease;
    private String typeofservices;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String addressLine1;
    private String address;
    private String referralDoctorName;
    private String diagnosticCenter;
    private String gender;
    private int age;
    private String amount;
    private String collection;
   
    private String patientEmail;
   
    private String patientMobileNumber;
    @Lob
    @Column(name = "prescription" ,columnDefinition ="MEDIUMBLOB")
    private byte[] prescription; // Store prescription file as byte array

    // Constructors, getters, and setters

    public Patient() {
        // Default constructor
    }
    
    

	public Patient(String appointmentRefId, String patientId, String patientName, String tests, String chronicDisease,
			String typeofservices, LocalDate bookingDate, LocalTime bookingTime, String addressLine1, String address,
			String referralDoctorName, String diagnosticCenter, String gender, int age, String amount,
			String collection, byte[] prescription, String patientEmail,String patientMobileNumber) {
		super();
		this.appointmentRefId = appointmentRefId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.tests = tests;
		this.chronicDisease = chronicDisease;
		this.typeofservices = typeofservices;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.addressLine1 = addressLine1;
		this.address = address;
		this.referralDoctorName = referralDoctorName;
		this.diagnosticCenter = diagnosticCenter;
		this.gender = gender;
		this.age = age;
		this.amount = amount;
		this.collection = collection;
		this.prescription = prescription;
		this.patientEmail = patientEmail;
		this.patientMobileNumber = patientMobileNumber;
		
	}



	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getAppointmentRefId() {
		return appointmentRefId;
	}

	public void setAppointmentRefId(String appointmentRefId) {
		this.appointmentRefId = appointmentRefId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getTests() {
		return tests;
	}

	public void setTests(String tests) {
		this.tests = tests;
	}

	public String getChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public String getTypeofservices() {
		return typeofservices;
	}

	public void setTypeofservices(String typeofservices) {
		this.typeofservices = typeofservices;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferralDoctorName() {
		return referralDoctorName;
	}

	public void setReferralDoctorName(String referralDoctorName) {
		this.referralDoctorName = referralDoctorName;
	}

	public String getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnosticCenter(String diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	public byte[] getPrescription() {
		return prescription;
	}

	public void setPrescription(byte[] prescription) {
		this.prescription = prescription;
	}

    // Constructor with all fields except ID
    
    
    
    // Getters and Setters for all fields
}


