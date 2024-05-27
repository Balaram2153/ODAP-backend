package com.Online_Physical_Consultant.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="Online_Physical_Services")
public class Slot_Booking_Entity 
{
	@Id
    private String appointmentId;
	
    private String speciality; 
    
    private String doctorName;

    private String hospitalName;
    
    private String address;   
    
    private String slotDates;

    private String bookingDate;
    
    private String age;
    
    private String gender;
    
    private String chronicDisease;

    private String bookingTime;
    
    private String patientName;
    
    private String patientId;

    @Email
    private String patientEmail;

    private Long patientMobileNumber;

    @Lob
    @Column(name = "patientPreviousReports" ,columnDefinition ="MEDIUMBLOB")
    private byte[] patientPreviousReports; // Store prescription file as byte array

    private String typeOfService; 
    
    private String patientDescription;
    
    private String webLink;
    
    private String fee;
    private String totalFee;
    
    public Slot_Booking_Entity() {
		super();
	}
    
	



	public Slot_Booking_Entity(String appointmentId, String slotDates,String speciality, String doctorName, String hospitalName, String address,
			String bookingDate, String patientId, String bookingTime, String patientName, @Email String patientEmail,
			Long patientMobileNumber, String webLink, byte[] patientPreviousReports, String typeOfService, String patientDescription,
			String fee, String age, String chronicDisease, String gender, String totalFee) {
		super();
		this.appointmentId = appointmentId;
		this.speciality = speciality;
		this.doctorName = doctorName;
		this.hospitalName = hospitalName;
		this.address = address;
		this.bookingDate = bookingDate;
		this.slotDates=slotDates;
		this.bookingTime = bookingTime;
		this.patientName = patientName;
		this.webLink=webLink;
		this.age=age;
		this.chronicDisease=chronicDisease;
		this.gender=gender;
		this.patientId=patientId;
		this.patientEmail = patientEmail;
		this.patientMobileNumber = patientMobileNumber;
		this.patientPreviousReports = patientPreviousReports;
		this.typeOfService = typeOfService;
		this.patientDescription = patientDescription;
		this.fee = fee;
		this.totalFee = totalFee;
	}




	

	public String getChronicDisease() {
		return chronicDisease;
	}





	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}





	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	

	public String getWebLink() {
		return webLink;
	}



	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}



	
	public String getAge() {
		return age;
	}





	public void setAge(String age) {
		this.age = age;
	}





	public String getGender() {
		return gender;
	}





	public void setGender(String gender) {
		this.gender = gender;
	}





	public String getPatientId() {
		return patientId;
	}



	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	

	public String getAppointmentId() {
		return appointmentId;
	}





	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}





	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public Long getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(Long patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	

	public byte[] getPatientPreviousReports() {
		return patientPreviousReports;
	}





	public void setPatientPreviousReports(byte[] patientPreviousReports) {
		this.patientPreviousReports = patientPreviousReports;
	}





	public String getPatientDescription() {
		return patientDescription;
	}

	public void setPatientDescription(String patientDescription) {
		this.patientDescription = patientDescription;
	}


	public String getTypeOfService() {
		return typeOfService;
	}


	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	 public String getFee() {
			return fee;
		}

		public void setFee(String fee) {
			this.fee = fee;
		}

		public String getTotalFee() {
			return totalFee;
		}

		public void setTotalFee(String totalFee) {
			this.totalFee = totalFee;
		}



		public String getSlotDates() {
			return slotDates;
		}



		public void setSlotDates(String slotDates) {
			this.slotDates = slotDates;
		}
	

}