package com.odrp.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.odrp.Entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate , Long >{

    List<Candidate > findALLByPatientId(String patientId);

}
