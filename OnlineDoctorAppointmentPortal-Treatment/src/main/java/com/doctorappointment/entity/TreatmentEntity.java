package com.doctorappointment.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class TreatmentEntity {
	

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private LocalDate bookingDate;	
	private String patientName;
	private String doctorName;
	private String patientEmail;
	private String prognosis;
	private String temperature;
	private String treatment;
	private String spO2;
	private String bp;
	
	@Lob
	@Column(name = "file", columnDefinition = "MEDIUMBLOB")
	private byte[] file;
	private Date followupDate;
	private String recommendedTest;
	
    private String medicineName;
	private String medicineType;
	private String form;
//	private String suspension;
//	private String dispensable;
	private String quantity;
	private String dosageTiming;
	
	
	
	
	
	
	public TreatmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public TreatmentEntity(long id, LocalDate bookingDate, String patientName, String doctorName, String patientEmail,
			String prognosis, String temperature, String treatment, String spO2, String bp, byte[] file,
			Date followupDate, String recommendedTest, String medicineName, String medicineType, String form,
			String quantity, String dosageTiming) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.patientEmail = patientEmail;
		this.prognosis = prognosis;
		this.temperature = temperature;
		this.treatment = treatment;
		this.spO2 = spO2;
		this.bp = bp;
		this.file = file;
		this.followupDate = followupDate;
		this.recommendedTest = recommendedTest;
		this.medicineName = medicineName;
		this.medicineType = medicineType;
		this.form = form;
		this.quantity = quantity;
		this.dosageTiming = dosageTiming;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public LocalDate getBookingDate() {
		return bookingDate;
	}




	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}




	public String getPatientName() {
		return patientName;
	}




	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}




	public String getDoctorName() {
		return doctorName;
	}




	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}




	public String getPatientEmail() {
		return patientEmail;
	}




	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}




	public String getPrognosis() {
		return prognosis;
	}




	public void setPrognosis(String prognosis) {
		this.prognosis = prognosis;
	}




	public String getTemperature() {
		return temperature;
	}




	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}




	public String getTreatment() {
		return treatment;
	}




	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}




	public String getSpO2() {
		return spO2;
	}




	public void setSpO2(String spO2) {
		this.spO2 = spO2;
	}




	public String getBp() {
		return bp;
	}




	public void setBp(String bp) {
		this.bp = bp;
	}




	public byte[] getFile() {
		return file;
	}




	public void setFile(byte[] file) {
		this.file = file;
	}




	public Date getFollowupDate() {
		return followupDate;
	}




	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}




	public String getRecommendedTest() {
		return recommendedTest;
	}




	public void setRecommendedTest(String recommendedTest) {
		this.recommendedTest = recommendedTest;
	}




	public String getMedicineName() {
		return medicineName;
	}




	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}




	public String getMedicineType() {
		return medicineType;
	}




	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}




	public String getForm() {
		return form;
	}




	public void setForm(String form) {
		this.form = form;
	}




	public String getQuantity() {
		return quantity;
	}




	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}




	public String getDosageTiming() {
		return dosageTiming;
	}




	public void setDosageTiming(String dosageTiming) {
		this.dosageTiming = dosageTiming;
	}


















}
