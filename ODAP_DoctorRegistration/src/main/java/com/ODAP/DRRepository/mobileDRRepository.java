package com.ODAP.DRRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ODAP.DREntity.MobileDR;


@Repository
public interface mobileDRRepository extends JpaRepository<MobileDR, Long>{
	
	MobileDR findByPhoneNumberAndOtp(String phoneNumber,String otp);
	
	MobileDR findByPhoneNumber(String phoneNumber);

}
