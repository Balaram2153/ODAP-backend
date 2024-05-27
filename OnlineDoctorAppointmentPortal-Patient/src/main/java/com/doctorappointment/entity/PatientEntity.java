package com.doctorappointment.entity;


import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PatientEntity {
	
	@Id
	private  String patientId;
	private  String patientName;	
	@Column(unique=true)
    private String patientEmail;
	@Column(unique=true)
	private String patientMobileNumber;	
	private String medicalInformation;
	private String bloodGroup;
	private String chronicDisease;
	private String familyDoctorName;
	private String attendeeName;
	private String emergencyContact;
	private String addressLine1;
	private String addressLine2;
	private  String city;
	private  String state;
	private String pincode;
	private String gender;
	private Date dob;
	private Long age;
	private String medicalInsurances;
	private String medicalInsuranceNumber;
	private String aadhar;
	private String password;
	private String confirmPassword;
	
	private String otp;
	private String enteredOTP;
	public PatientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientEntity(String patientId, String patientName, String patientEmail, String patientMobileNumber,
			String medicalInformation, String bloodGroup, String chronicDisease, String familyDoctorName,
			String attendeeName, String emergencyContact, String addressLine1, String addressLine2, String city,Long age,
			String state, String pincode, String gender, String otp, String enteredOTP,Date dob, String medicalInsurances,
			String medicalInsuranceNumber, String aadhar, String password, String confirmPassword) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientMobileNumber = patientMobileNumber;
		this.medicalInformation = medicalInformation;
		this.age=age;
		this.bloodGroup = bloodGroup;
		this.chronicDisease = chronicDisease;
		this.familyDoctorName = familyDoctorName;
		this.attendeeName = attendeeName;
		this.emergencyContact = emergencyContact;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.gender = gender;
		this.dob = dob;
		this.medicalInsurances = medicalInsurances;
		this.medicalInsuranceNumber = medicalInsuranceNumber;
		this.aadhar = aadhar;
		this.otp = otp;
		this.enteredOTP = enteredOTP;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}









	public String getOtp() {
		return otp;
	}








	public Long getAge() {
		return age;
	}









	public void setAge(Long age) {
		this.age = age;
	}









	public void setOtp(String otp) {
		this.otp = otp;
	}





	public String getEnteredOTP() {
		return enteredOTP;
	}





	public void setEnteredOTP(String enteredOTP) {
		this.enteredOTP = enteredOTP;
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


	public String getMedicalInformation() {
		return medicalInformation;
	}


	public void setMedicalInformation(String medicalInformation) {
		this.medicalInformation = medicalInformation;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getChronicDisease() {
		return chronicDisease;
	}


	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}


	public String getFamilyDoctorName() {
		return familyDoctorName;
	}


	public void setFamilyDoctorName(String familyDoctorName) {
		this.familyDoctorName = familyDoctorName;
	}


	public String getAttendeeName() {
		return attendeeName;
	}


	public void setAttendeeName(String attendeeName) {
		this.attendeeName = attendeeName;
	}


	public String getEmergencyContact() {
		return emergencyContact;
	}


	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMedicalInsurances() {
		return medicalInsurances;
	}


	public void setMedicalInsurances(String medicalInsurances) {
		this.medicalInsurances = medicalInsurances;
	}


	public String getAadhar() {
		return aadhar;
	}


	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}












































	public Date getDob() {
		return dob;
	}































	public void setDob(Date dob) {
		this.dob = dob;
	}































	public String getMedicalInsuranceNumber() {
		return medicalInsuranceNumber;
	}





	public void setMedicalInsuranceNumber(String medicalInsuranceNumber) {
		this.medicalInsuranceNumber = medicalInsuranceNumber;
	}
	
	
	
	
	
}
	
	
	