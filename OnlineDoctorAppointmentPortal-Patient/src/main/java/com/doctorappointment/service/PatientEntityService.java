package com.doctorappointment.service;

import java.util.List;

import com.doctorappointment.entity.PatientEntity;

public interface PatientEntityService {
	
	public PatientEntity register(PatientEntity patient);
	
	public PatientEntity getPatient(String patientId);
	
	public void deletePatient(String patientId);
	 
	public List<PatientEntity>getallpatients();
	
	public void updatepatient(String patientId, PatientEntity patient);
	

	public boolean sendEmailconfirm(String patientEmail, String patientId);
	
	public boolean doesEmailExist(String patientEmail);

	public String verifyOTP(String phoneNumber, String enteredOTP);	

}
