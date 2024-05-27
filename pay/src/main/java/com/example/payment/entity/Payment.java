package com.example.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="payment_Medical_details")
@Entity
public class Payment {
    @Id
    private String paymentid;
    private String patientId;
    private String typeofservices;
    private String patientName;
	private String hospitalname;
	private String procedures;
    private String date;
    private String slottime;
    private String amount;
    private String paymenttype;
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSlottime() {
		return slottime;
	}
	public void setSlottime(String slottime) {
		this.slottime = slottime;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getTypeofservices() {
		return typeofservices;
	}
	public void setTypeofservices(String typeofservices) {
		this.typeofservices = typeofservices;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(String paymentid, String patientId, String typeofservices, String patientName, String hospitalname,
			String procedures, String date, String slottime, String amount, String paymenttype) {
		super();
		this.paymentid = paymentid;
		this.patientId = patientId;
		this.typeofservices = typeofservices;
		this.patientName = patientName;
		this.hospitalname = hospitalname;
		this.procedures = procedures;
		this.date = date;
		this.slottime = slottime;
		this.amount = amount;
		this.paymenttype = paymenttype;
	}
	
    
    
    

    // Getters and setters
    // Constructor
    
    
    
    
}