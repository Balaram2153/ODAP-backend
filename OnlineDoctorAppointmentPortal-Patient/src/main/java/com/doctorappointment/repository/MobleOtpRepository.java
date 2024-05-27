package com.doctorappointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorappointment.entity.MobileOtpVerification;
import java.util.List;


@Repository
public interface MobleOtpRepository extends JpaRepository<MobileOtpVerification, Long> {
	
	MobileOtpVerification findBypatientMobileNumber(String patientMobileNumber);
	
	MobileOtpVerification  findByPatientMobileNumberAndOtp(String patientMobileNumber, String otp);

//	void saves(MobileOtpVerification otpMessage);

}
