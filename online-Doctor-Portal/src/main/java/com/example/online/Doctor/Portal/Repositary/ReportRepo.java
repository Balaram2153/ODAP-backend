package com.example.online.Doctor.Portal.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online.Doctor.Portal.Entity.Reports;

@Repository
public interface ReportRepo extends JpaRepository<Reports, Long> {
	
	List<Reports>findByDoctorName(String doctorName);

}
