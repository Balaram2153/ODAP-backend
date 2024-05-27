package Patient.Book.Test.Dto;

public class LoginRequest {
    private String email;
    private String mobileNumber;
   

    // Default constructor
    public LoginRequest() {
    }

    // Parameterized constructor
    public LoginRequest(String email, String mobileNumber) {
        this.email = email;
        this.mobileNumber = mobileNumber;
       
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

   
}
