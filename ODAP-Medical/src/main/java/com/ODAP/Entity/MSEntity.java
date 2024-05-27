package com.ODAP.Entity;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MSEntity {
	
	@Id
	private String medicalid;
	private String patientId;
	private String patientName;
	private String referaldoctorname;
	private Date bookingdate;
	private String typeofservices;
	private String hospitalname;
	private String slottime;
	private String procedures;
	private String amount;
	private String email;
	private String patientMobileNumber;
	public MSEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MSEntity(String medicalid, String patientId,String patientName, String referaldoctorname, Date bookingdate, String typeofservices,
			String hospitalname, String slottime, String procedures, String amount, String email,
			String patientMobileNumber) {
		super();
		this.medicalid = medicalid;
		this.patientName = patientName;
		this.patientId=patientId;
		this.referaldoctorname = referaldoctorname;
		this.bookingdate = bookingdate;
		this.typeofservices = typeofservices;
		this.hospitalname = hospitalname;
		this.slottime = slottime;
		this.procedures = procedures;
		this.amount = amount;
		this.email = email;
		this.patientMobileNumber = patientMobileNumber;
	}
	
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getMedicalid() {
		return medicalid;
	}
	public void setMedicalid(String medicalid) {
		this.medicalid = medicalid;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getReferaldoctorname() {
		return referaldoctorname;
	}
	public void setReferaldoctorname(String referaldoctorname) {
		this.referaldoctorname = referaldoctorname;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getTypeofservices() {
		return typeofservices;
	}
	public void setTypeofservices(String typeofservices) {
		this.typeofservices = typeofservices;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public String getSlottime() {
		return slottime;
	}
	public void setSlottime(String slottime) {
		this.slottime = slottime;
	}
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}
	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}
	
	
	
	
}