package com.example.online.Doctor.Portal.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online.Doctor.Portal.Entity.PatientReport;

@Repository
public interface PatientReportsRepo extends JpaRepository<PatientReport, Long>{

}
