package com.ODAP.Entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity

public class Report {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	private String patientEmail;
	@Lob
	@Column(name = "file", columnDefinition = "MEDIUMBLOB")
	private byte[] file;
	
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Report(long id, String patientEmail, byte[] file) {
		super();
		this.id = id;
		this.patientEmail = patientEmail;
		this.file = file;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	
	
}
