package com.doctorappointment.service;

import java.util.List;

import com.doctorappointment.entity.TreatmentEntity;

public interface TreatmentService {
	
	
	public List<TreatmentEntity>getalltreatments();
	
	public List<TreatmentEntity>getbydoctor(String doctorName);

}
