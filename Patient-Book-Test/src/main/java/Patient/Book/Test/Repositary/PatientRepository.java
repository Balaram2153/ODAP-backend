package Patient.Book.Test.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Patient.Book.Test.enity.Patient;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByPatientEmail(String patientEmail);

    Optional<Patient> findByPatientMobileNumber(String patientMobileNumber);
    
    List<Patient>findByDiagnosticCenter(String diagnosticCenter);
    
    List<Patient> findByPatientName(String patientName);

	List<Patient> findByPatientId(String patientId);
    
}



