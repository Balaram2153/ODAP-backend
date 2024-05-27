package com.Online_Physical_Consultant.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PaymentEntity {

	@Id
	private int transactionID;
	private String patientName;
	private String patientEmail;
	private String patientMobileNumber;
    private String speciality;     
    private String doctorName;  
    private String typeOfService;
    private String hospitalName;
    private String address;
    private String bookingDate;
    private String bookingTime;
    private String modeOfPayment;
    private String fee;
    private String totalFee;
    private String cardNumber;
    private String cvv;
    private String expiry;
    private String upiID;
   
    
	public PaymentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PaymentEntity(int transactionID, String patientEmail, String typeOfService,String hospitalName,String patientName, String speciality, String doctorName, String address,
			String bookingDate, String totalFee,String patientMobileNumber,String bookingTime, String modeOfPayment, String fee, String cardNumber, String cvv,
			String expiry, String upiID) {
		super();
		
		this.transactionID = transactionID;
		this.patientName = patientName;
		this.speciality = speciality;
		this.doctorName = doctorName;
		this.patientEmail=patientEmail;
		this.totalFee=totalFee;
		this.patientMobileNumber=patientMobileNumber;
		this.typeOfService=typeOfService;
		this.hospitalName=hospitalName;
		this.address = address;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.modeOfPayment = modeOfPayment;
		this.fee = fee;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiry = expiry;
		this.upiID = upiID;
		
	}

    public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getExpiry() {
		return expiry;
	}

	

	public String getTypeOfService() {
		return typeOfService;
	}


	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}


	public String getHospitalName() {
		return hospitalName;
	}


	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}


	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}


	public String getUpiID() {
		return upiID;
	}


	public void setUpiID(String upiID) {
		this.upiID = upiID;
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


	public String getTotalFee() {
		return totalFee;
	}


	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	


	
	
}
