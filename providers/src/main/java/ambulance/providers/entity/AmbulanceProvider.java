package ambulance.providers.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "Ambulence_Providers")
@Entity
public class AmbulanceProvider {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 private String name;
 private String email;
 private String mobile;
 private String fee;
 private String servname;
 
public AmbulanceProvider(Long id, String name, String email, String mobile, String fee, String servname) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.mobile = mobile;
	this.fee = fee;
	this.servname = servname;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getFee() {
	return fee;
}

public void setFee(String fee) {
	this.fee = fee;
}

public String getServname() {
	return servname;
}

public void setServname(String servname) {
	this.servname = servname;
}

@Override
public String toString() {
	return "AmbulanceProvider [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", fee=" + fee
			+ ", servname=" + servname + "]";
}
 
 
 
}
