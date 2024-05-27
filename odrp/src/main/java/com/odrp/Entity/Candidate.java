package com.odrp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ambulence_info")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;
    private String patientId;
    private String email;
    private String mobileNumber;
    private String facilities;
    private String disease;
    private String providers;
    private String date;
    private String time;
    private String fromLocation;
    private String toLocation;
    private String fromLine1;
    private String fromLine2;
    private String fromCity;
    private String toLine1;
    private String toLine2;
    private String toCity;
    private String fromHospitalName;
    private String toHospitalName;
    private String uniqueId;
    private String totalFee;

    public Candidate() {
    }

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getProviders() {
		return providers;
	}

	public void setProviders(String providers) {
		this.providers = providers;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getFromLine1() {
		return fromLine1;
	}

	public void setFromLine1(String fromLine1) {
		this.fromLine1 = fromLine1;
	}

	public String getFromLine2() {
		return fromLine2;
	}

	public void setFromLine2(String fromLine2) {
		this.fromLine2 = fromLine2;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToLine1() {
		return toLine1;
	}

	public void setToLine1(String toLine1) {
		this.toLine1 = toLine1;
	}

	public String getToLine2() {
		return toLine2;
	}

	public void setToLine2(String toLine2) {
		this.toLine2 = toLine2;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getFromHospitalName() {
		return fromHospitalName;
	}

	public void setFromHospitalName(String fromHospitalName) {
		this.fromHospitalName = fromHospitalName;
	}

	public String getToHospitalName() {
		return toHospitalName;
	}

	public void setToHospitalName(String toHospitalName) {
		this.toHospitalName = toHospitalName;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}


	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}


	public Candidate(Long candidateId, String patientId, String email, String mobileNumber, String facilities,
			String disease, String providers, String date, String time, String fromLocation, String toLocation,
			String fromLine1, String fromLine2, String fromCity, String toLine1, String toLine2, String toCity,
			String fromHospitalName, String toHospitalName, String uniqueId,String totalFee) {
		super();
		this.candidateId = candidateId;
		this.patientId = patientId;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.facilities = facilities;
		this.disease = disease;
		this.providers = providers;
		this.date = date;
		this.time = time;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromLine1 = fromLine1;
		this.fromLine2 = fromLine2;
		this.fromCity = fromCity;
		this.toLine1 = toLine1;
		this.toLine2 = toLine2;
		this.toCity = toCity;
		this.fromHospitalName = fromHospitalName;
		this.toHospitalName = toHospitalName;
		this.uniqueId = uniqueId;
		this.totalFee = totalFee;

	}

	
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", patientId=" + patientId + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", facilities=" + facilities + ", disease=" + disease
				+ ", providers=" + providers + ", date=" + date + ", time=" + time + ", fromLocation=" + fromLocation
				+ ", toLocation=" + toLocation + ", fromLine1=" + fromLine1 + ", fromLine2=" + fromLine2 + ", fromCity="
				+ fromCity + ", toLine1=" + toLine1 + ", toLine2=" + toLine2 + ", toCity=" + toCity
				+ ", fromHospitalName=" + fromHospitalName + ", toHospitalName=" + toHospitalName + ", uniqueId="
				+ uniqueId + "]";
	}
 
   
}
