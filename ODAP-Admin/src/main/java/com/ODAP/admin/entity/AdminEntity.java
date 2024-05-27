package com.ODAP.admin.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminEntity {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	private String adminEmail;
	private String password;
	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AdminEntity(long adminId, String adminEmail, String password) {
		super();
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		this.password = password;
	}


	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
