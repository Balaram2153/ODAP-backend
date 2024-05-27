
package com.ODAP.DRService;

import java.util.List;

import com.ODAP.DREntity.DREntity;
import com.ODAP.DREntity.WeeklyUpdate;


public interface DRService {
	
	public String saveRegistration(DREntity doctor);
	
	public List<DREntity> getbydoctor(String doctorName);
	
	public WeeklyUpdate saveWeeklyUpdates(WeeklyUpdate weeklyUpdate);
	
	public WeeklyUpdate getWeeklyUpdateById(String doctorId);

	boolean sendEmailconfirm(String email, String doctorId);
	
	public String verifyOTP(String phoneNumber, String enteredOTP);

}
