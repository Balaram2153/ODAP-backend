package Patient.Book.Test.enity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name")
    private String patientName;
    
    private String modeOfPayment;

    private String tests;

    @Column(name = "chronic_disease")
    private String chronicDisease;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "booking_time")
    private LocalTime bookingTime;

    @Column(name = "address_line_1")
    private String addressLine1;

    private String address;

    @Column(name = "referral_doctor_name")
    private String referralDoctorName;

    @Column(name = "diagnostic_center")
    private String diagnosticCenter;

    private String gender;

    private int age;

    private String amount;

    private String collection;

    @Column(name = "patient_email")
    private String patientEmail;

    @Column(name = "patient_mobile_number")
    private String patientMobileNumber;

    @Lob
    @Column(name = "prescription", columnDefinition = "MEDIUMBLOB")
    private byte[] prescription;

    // Constructors, getters, and setters

    public PaymentDetails() {
    }

    // Constructor excluding ID
    public PaymentDetails(String patientName, String tests, String chronicDisease, String serviceType,
                          LocalDate bookingDate, LocalTime bookingTime, String addressLine1, String address,
                          String referralDoctorName, String diagnosticCenter, String gender, int age,
                          String amount, String collection, String patientEmail, String patientMobileNumber,
                          byte[] prescription,String modeOfPayment) {
        this.patientName = patientName;
        this.tests = tests;
        this.chronicDisease = chronicDisease;
        this.serviceType = serviceType;
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
        this.patientEmail = patientEmail;
        this.patientMobileNumber = patientMobileNumber;
        this.prescription = prescription;
        this.modeOfPayment=modeOfPayment;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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

    // Getters and setters
}

