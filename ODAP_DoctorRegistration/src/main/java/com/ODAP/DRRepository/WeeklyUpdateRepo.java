
package com.ODAP.DRRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ODAP.DREntity.WeeklyUpdate;

@Repository
public interface WeeklyUpdateRepo extends JpaRepository<WeeklyUpdate, Long> {
	
	//public WeeklyUpdate findByDoctorName(String doctorName);
	
	public Optional<WeeklyUpdate> findByDoctorId(String doctorId);
	


}
