package com.odrp.Controller;

import java.util.List;  
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.odrp.Entity.Candidate;
import com.odrp.Repository.CandidateRepository;
import com.odrp.Service.EmailService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class CandidateController {

    @Autowired
    public CandidateRepository candRepo;
    
    @PostMapping("/insert")
    public ResponseEntity<Candidate> regist(@RequestBody Candidate candidate) throws MessagingException{
        try {
            // Generate a 6-digit unique ID
            String uniqueId = UUID.randomUUID().toString().substring(0, 6); 
            candidate.setUniqueId(uniqueId);
            
            System.out.println("Received candidate data: " + candidate);
            Candidate savedCandidate = candRepo.save(candidate);
            
            EmailService.sendEmail(savedCandidate.getEmail(), uniqueId);
            return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    

    @GetMapping("/getAll")
    public ResponseEntity<List<Candidate>> get() {
        return new ResponseEntity<>(candRepo.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/getByPatientId/{patientId}")
    public ResponseEntity<List<Candidate>> getByPatientId(@PathVariable String patientId) {
        try {
            List<Candidate> candidate = candRepo.findALLByPatientId(patientId);
            		if (candidate != null) {
                return new ResponseEntity<>(candidate, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
