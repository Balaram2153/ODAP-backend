package Patient.Book.Test.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import Patient.Book.Test.ExceptionHandlers.CustomException;
import Patient.Book.Test.Repositary.PatientRepository;
import Patient.Book.Test.enity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) throws CustomException {
        try {
            return patientRepository.save(patient);
        } catch (Exception e) {
            throw new CustomException("Failed to create patient", e);
        }
    }

    @Override
    public Optional<Patient> getPatientById(long id) throws CustomException {
        try {
            return patientRepository.findById(id);
        } catch (Exception e) {
            throw new CustomException("Failed to retrieve patient by ID", e);
        }
    }

    @Override
    public Optional<Patient> getPatientByEmail(String patientEmail) throws CustomException {
        try {
            return patientRepository.findByPatientEmail(patientEmail);
        } catch (Exception e) {
            throw new CustomException("Failed to retrieve patient by email", e);
        }
    }

    @Override
    public Optional<Patient> getPatientByMobileNumber(String patientMobileNumber) throws CustomException {
        try {
            return patientRepository.findByPatientMobileNumber(patientMobileNumber);
        } catch (Exception e) {
            throw new CustomException("Failed to retrieve patient by mobile number", e);
        }
    }

//    @Override
//    public Patient updatePatient(String appointmentRefId, Patient patient) throws CustomException {
//        try {
//            if (patientRepository.existsById(appointmentRefId)) {
//                patient.setPatientId(appointmentRefId);
//                return patientRepository.save(patient);
//            } else {
//                throw new CustomException("Patient not found with ID: " + appointmentRefId);
//            }
//        } catch (Exception e) {
//            throw new CustomException("Failed to update patient", e);
//        }
//    }

//    @Override
//    public void deletePatient(String appointmentRefId) throws CustomException {
//        try {
//            if (patientRepository.existsById(appointmentRefId)) {
//                patientRepository.deleteById(appointmentRefId);
//            } else {
//                throw new CustomException("Patient not found with ID: " + appointmentRefId);
//            }
//        } catch (Exception e) {
//            throw new CustomException("Failed to delete patient", e);
//        }
//    }

    @Override
    public List<Patient> getAllPatients() throws CustomException {
        try {
            return patientRepository.findAll();
        } catch (Exception e) {
            throw new CustomException("Failed to retrieve all patients", e);
        }
    }

	@Override
	public List<Patient> getalldiagnostics(String diagnosticCenter) {
		// TODO Auto-generated method stub
		return patientRepository.findByDiagnosticCenter(diagnosticCenter);
	}
}


