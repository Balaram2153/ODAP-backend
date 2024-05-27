package Patient.Book.Test.Services;

import java.util.List;
import java.util.Optional;

import Patient.Book.Test.enity.Patient;
import Patient.Book.Test.ExceptionHandlers.CustomException;

public interface PatientService {

    Patient createPatient(Patient patient) throws CustomException;

    Optional<Patient> getPatientById(long id) throws CustomException;

    Optional<Patient> getPatientByEmail(String patientEmail) throws CustomException;

    Optional<Patient> getPatientByMobileNumber(String patientMobileNumber) throws CustomException;

//    Patient updatePatient(String appointmentRefId, Patient patient) throws CustomException;
//
//    void deletePatient(String appointmentRefId) throws CustomException;

    List<Patient> getAllPatients() throws CustomException;
    
    List<Patient>getalldiagnostics(String diagnosticCenter);
}

