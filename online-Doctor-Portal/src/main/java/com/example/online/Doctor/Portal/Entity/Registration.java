package com.example.online.Doctor.Portal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Registration {
	
	@Id	
	private String technicianId;
	private String technicianname;
	private String email;
	private String mobilenumber;
	private String technicianstudy;
	private String typeofservices;
	private String technicianexperiences;
	private String diagnosticCenter;
	private String diagnosticaddress;
	private String password;
	private String confirmpassword;
	private String emailOtp;
	private String enteredOtp;
	private String newPassword;
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Registration(String technicianId, String technicianname, String email, String mobilenumber,
			String technicianstudy, String typeofservices, String technicianexperiences, String diagnosticCenter,
			String diagnosticaddress, String password, String confirmpassword, String emailOtp, String enteredOtp,
			String newPassword) {
		super();
		this.technicianId = technicianId;
		this.technicianname = technicianname;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.technicianstudy = technicianstudy;
		this.typeofservices = typeofservices;
		this.technicianexperiences = technicianexperiences;
		this.diagnosticCenter = diagnosticCenter;
		this.diagnosticaddress = diagnosticaddress;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.emailOtp = emailOtp;
		this.enteredOtp = enteredOtp;
		this.newPassword = newPassword;
	}



	public String getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}

	public String getTechnicianname() {
		return technicianname;
	}

	public void setTechnicianname(String technicianname) {
		this.technicianname = technicianname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getTechnicianstudy() {
		return technicianstudy;
	}

	public void setTechnicianstudy(String technicianstudy) {
		this.technicianstudy = technicianstudy;
	}

	public String getTypeofservices() {
		return typeofservices;
	}

	public void setTypeofservices(String typeofservices) {
		this.typeofservices = typeofservices;
	}

	public String getTechnicianexperiences() {
		return technicianexperiences;
	}

	public void setTechnicianexperiences(String technicianexperiences) {
		this.technicianexperiences = technicianexperiences;
	}

	public String getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnosticCenter(String diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	public String getDiagnosticaddress() {
		return diagnosticaddress;
	}

	public void setDiagnosticaddress(String diagnosticaddress) {
		this.diagnosticaddress = diagnosticaddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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
	
	

	

}

