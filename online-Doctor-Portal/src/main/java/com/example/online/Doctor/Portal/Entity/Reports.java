package com.example.online.Doctor.Portal.Entity;


import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Reports {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private long id;
	private String patientName;
	private String testtype;
	private String attendeddoctor;
	private String diagnosticCenter;
	private String reports;
	private String patientEmail;
	private String doctorEmail;
	private String doctorName;
	@Lob
	@Column(name = "file", columnDefinition = "MEDIUMBLOB")
	private byte[] file;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTesttype() {
		return testtype;
	}
	public void setTesttype(String testtype) {
		this.testtype = testtype;
	}
	public String getAttendeddoctor() {
		return attendeddoctor;
	}
	public void setAttendeddoctor(String attendeddoctor) {
		this.attendeddoctor = attendeddoctor;
	}
		public String getReports() {
		return reports;
	}
	public void setReports(String reports) {
		this.reports = reports;
	}
	
	
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDiagnosticCenter() {
		return diagnosticCenter;
	}
	public void setDiagnosticCenter(String diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public Reports() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reports(long id, String patientName, String testtype, String attendeddoctor, String diagnosticCenter,
			String reports, String patientEmail, String doctorName,String doctorEmail, byte[] file) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.testtype = testtype;
		this.doctorName=doctorName;
		this.attendeddoctor = attendeddoctor;
		this.diagnosticCenter = diagnosticCenter;
		this.reports = reports;
		this.patientEmail = patientEmail;
		this.doctorEmail = doctorEmail;
		this.file = file;
	}
	
	
	
}
