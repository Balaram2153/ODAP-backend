package com.ODAP.DREntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "slotDates")
public class WeeklyUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private List<String> slotDates;

    private LocalTime startTime;
    
    private LocalTime endTime;    
    
    private String doctorId;
    
	public WeeklyUpdate() {
		super();
	}
	public WeeklyUpdate(Long id, String doctorId, List<String> slotDates, LocalTime startTime, LocalTime endTime) {
		super();
		this.id = id;
		this.doctorId = doctorId;
		this.slotDates = slotDates;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<String> getSlotDates() {
		return slotDates;
	}
	public void setSlotDates(List<String> slotDates) {
		this.slotDates = slotDates;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	} 
}
