package com.doctorappointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorappointment.entity.MedicineFormEntity;
import com.doctorappointment.repository.MedicineFormRepo;

@RestController
@RequestMapping("/medicine-form")
@CrossOrigin("*")
public class MedicineFormController {

    @Autowired
    private MedicineFormRepo medicinerepo;

    @PostMapping("/submit")
    public MedicineFormEntity submitMedicineForm(@RequestBody MedicineFormEntity formData) {
        
    	return medicinerepo.save(formData);
    }

    
    
    @GetMapping("/{id}")
    public MedicineFormEntity getMedicineFormById(@PathVariable Long id) {
        // Implement logic to retrieve medicine form by ID from service
        // Replace the return statement with your implementation
        return medicinerepo.findById(id).orElse(null);
    }
    

	/*
	 * @GetMapping("/getname/{name}") public List<MedicineFormEntity>
	 * getname(@PathVariable String name) { // Implement logic to retrieve medicine
	 * form by ID from service // Replace the return statement with your
	 * implementation // String n=name.toString(); return
	 * medicinerepo.findByName(name); }
	 */

    @GetMapping("/all")
    public List<MedicineFormEntity>getAllMedicineForms() {
        // Implement logic to retrieve all medicine forms from service
        // Replace the return statement with your implementation
    	
        return medicinerepo.findAll();
    }
    
    
    @GetMapping("/medicines/search/{name}")
    public ResponseEntity<List<MedicineFormEntity>> searchMedicinesByName(@PathVariable String name) {
        try {
            // Use the repository method to find MedicineFormEntities by name
            List<MedicineFormEntity> medicines = medicinerepo.findByNameContaining(name);
            if (medicines.isEmpty()) {
                // Return 404 Not Found if no medicines are found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            // Return 200 OK with the list of found medicines
            return new ResponseEntity<>(medicines, HttpStatus.OK);
        } catch (Exception e) {
            // Return 500 Internal Server Error if an exception occurs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

   

    

