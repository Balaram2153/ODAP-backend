package com.ODAP.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 

@Entity
public class Query {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String query;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Query(Long id, String query, String email) {
		super();
		this.id = id;
		this.query = query;
		this.email = email;
	}
	public Query() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Query [id=" + id + ", query=" + query + ", email=" + email + "]";
	}
	
	

}
