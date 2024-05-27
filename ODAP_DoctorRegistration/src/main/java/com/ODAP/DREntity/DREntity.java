package com.ODAP.DREntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class DREntity {

	@Id
	private String DoctorId;
	private String doctorName;
	private String speciality;
	private String Degree;
	private long Experience;
	private String Currentworkplace;
	private String Address1;
	private String Otherworkplace;
	private String Address2;
	private String hospitalName;
	private long Phonenumber;
	private long Registrationnumber;
	private String Registrationcouncil;
	private String Registrationyear;
	private String email;
	private String Password;
	private String ConfirmPassword;
	private String webLink;
	private String emailOtp;
	private String enteredOtp;	
	private String newPassword;
	public String getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(String doctorId) {
		DoctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDegree() {
		return Degree;
	}
	public void setDegree(String degree) {
		Degree = degree;
	}
	public long getExperience() {
		return Experience;
	}
	public void setExperience(long experience) {
		Experience = experience;
	}
	public String getCurrentworkplace() {
		return Currentworkplace;
	}
	public void setCurrentworkplace(String currentworkplace) {
		Currentworkplace = currentworkplace;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getOtherworkplace() {
		return Otherworkplace;
	}
	public void setOtherworkplace(String otherworkplace) {
		Otherworkplace = otherworkplace;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public long getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		Phonenumber = phonenumber;
	}
	public long getRegistrationnumber() {
		return Registrationnumber;
	}
	public void setRegistrationnumber(long registrationnumber) {
		Registrationnumber = registrationnumber;
	}
	public String getRegistrationcouncil() {
		return Registrationcouncil;
	}
	public void setRegistrationcouncil(String registrationcouncil) {
		Registrationcouncil = registrationcouncil;
	}
	public String getRegistrationyear() {
		return Registrationyear;
	}
	public void setRegistrationyear(String registrationyear) {
		Registrationyear = registrationyear;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	public String getWebLink() {
		return webLink;
	}
	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}
	public String getEmailOtp() {
		return emailOtp;
	}
	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}
	public String getEnteredOtp() {
		return enteredOtp;
	}
	public void setEnteredOtp(String enteredOtp) {
		this.enteredOtp = enteredOtp;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public DREntity(String doctorId, String doctorName, String speciality, String degree, long experience,
			String currentworkplace, String address1, String otherworkplace, String address2, String hospitalName,
			long phonenumber, long registrationnumber, String registrationcouncil, String registrationyear,
			String email, String password, String confirmPassword, String webLink, String emailOtp, String enteredOtp,
			String newPassword) {
		super();
		DoctorId = doctorId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		Degree = degree;
		Experience = experience;
		Currentworkplace = currentworkplace;
		Address1 = address1;
		Otherworkplace = otherworkplace;
		Address2 = address2;
		this.hospitalName = hospitalName;
		Phonenumber = phonenumber;
		Registrationnumber = registrationnumber;
		Registrationcouncil = registrationcouncil;
		Registrationyear = registrationyear;
		this.email = email;
		Password = password;
		ConfirmPassword = confirmPassword;
		this.webLink = webLink;
		this.emailOtp = emailOtp;
		this.enteredOtp = enteredOtp;
		this.newPassword = newPassword;
	}
	public DREntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DREntity [DoctorId=" + DoctorId + ", doctorName=" + doctorName + ", speciality=" + speciality
				+ ", Degree=" + Degree + ", Experience=" + Experience + ", Currentworkplace=" + Currentworkplace
				+ ", Address1=" + Address1 + ", Otherworkplace=" + Otherworkplace + ", Address2=" + Address2
				+ ", hospitalName=" + hospitalName + ", Phonenumber=" + Phonenumber + ", Registrationnumber="
				+ Registrationnumber + ", Registrationcouncil=" + Registrationcouncil + ", Registrationyear="
				+ Registrationyear + ", email=" + email + ", Password=" + Password + ", ConfirmPassword="
				+ ConfirmPassword + ", webLink=" + webLink + ", emailOtp=" + emailOtp + ", enteredOtp=" + enteredOtp
				+ ", newPassword=" + newPassword + "]";
	}
	
	
	
	
}
