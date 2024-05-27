package com.ODAP.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ODAP.Entity.MedicalPayment;

@Repository
public interface MedicalPaymentRepo extends JpaRepository<MedicalPayment, String> {

}
