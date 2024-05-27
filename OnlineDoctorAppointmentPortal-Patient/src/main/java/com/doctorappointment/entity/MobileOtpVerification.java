package com.doctorappointment.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PhoneOtpTbl")
public class MobileOtpVerification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotEmpty(message = "Phone number is required")
	@Column(unique = true)
	private String patientMobileNumber;
	
	private String otp;
	
	
	private String isVerify;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}


	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	public String getIsVerify() {
		return isVerify;
	}


	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify;
	}


	public MobileOtpVerification(Long id, String patientMobileNumber, String otp, String isVerify) {
		super();
		this.id = id;
		this.patientMobileNumber = patientMobileNumber;
		this.otp = otp;
		this.isVerify = isVerify;
	}


	public MobileOtpVerification() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MobileOtpVerification [id=" + id + ", patientMobileNumber=" + patientMobileNumber + ", otp=" + otp
				+ ", isVerify=" + isVerify + "]";
	}


	public void setPhonenumber(String numbers) {
		// TODO Auto-generated method stub
		
	}
	
	


}
