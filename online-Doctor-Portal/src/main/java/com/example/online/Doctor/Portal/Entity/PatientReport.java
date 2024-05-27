package com.example.online.Doctor.Portal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class PatientReport {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private long reportId;
	private String patientName;
	private String tests;
	private String referralDoctorName;
	private String diagnosticCenter;
	private String reports;
	private String patientEmail;
	private String doctorEmail;
	private String doctorName;
	private String typeofservices;
	private String appointmentRefId;
	
	@Lob
	@Column(name = "file", columnDefinition = "MEDIUMBLOB")
	private byte[] file;

	public PatientReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientReport(long reportId, String patientName, String tests, String referralDoctorName,
			String diagnosticCenter, String reports, String patientEmail, String doctorEmail, String doctorName,
			String typeofservices, String appointmentRefId, byte[] file) {
		super();
		this.reportId = reportId;
		this.patientName = patientName;
		this.tests = tests;
		this.referralDoctorName = referralDoctorName;
		this.diagnosticCenter = diagnosticCenter;
		this.reports = reports;
		this.patientEmail = patientEmail;
		this.doctorEmail = doctorEmail;
		this.doctorName = doctorName;
		this.typeofservices = typeofservices;
		this.appointmentRefId = appointmentRefId;
		this.file = file;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getTests() {
		return tests;
	}

	public void setTests(String tests) {
		this.tests = tests;
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

	public String getReports() {
		return reports;
	}

	public void setReports(String reports) {
		this.reports = reports;
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

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getTypeofservices() {
		return typeofservices;
	}

	public void setTypeofservices(String typeofservices) {
		this.typeofservices = typeofservices;
	}

	public String getAppointmentRefId() {
		return appointmentRefId;
	}

	public void setAppointmentRefId(String appointmentRefId) {
		this.appointmentRefId = appointmentRefId;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	

	
	
	
}