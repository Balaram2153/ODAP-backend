package com.ODAP.DREntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long contactId;
	public String doctorId;
	public String doctorName;
	public String phoneNumber;
	public String email;
	public String description;
	public String adminEmail;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Contact(long contactId,String doctorId, String doctorName, String phoneNumber, String email, String description,
			String adminEmail) {
		super();
		this.doctorId = doctorId;
		this.contactId = contactId;
		this.doctorName = doctorName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.description = description;
		this.adminEmail = adminEmail;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	
	
	

}
