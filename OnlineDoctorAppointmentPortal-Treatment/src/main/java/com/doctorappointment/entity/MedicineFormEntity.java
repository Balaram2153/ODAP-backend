package com.doctorappointment.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class MedicineFormEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String medicineType;
    private String measure;
    private String form;
    private String nos;
    private String dosageTiming;

    // Constructors, getters, and setters
    public MedicineFormEntity() {
    }

    public MedicineFormEntity(String name, String medicineType, String measure, String form, String nos, String dosageTiming) {
        this.name = name;
        this.medicineType = medicineType;
        this.measure = measure;
        this.form = form;
        this.nos = nos;
        this.dosageTiming = dosageTiming;
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

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getNos() {
        return nos;
    }

    public void setNos(String nos) {
        this.nos = nos;
    }

    public String getDosageTiming() {
        return dosageTiming;
    }

    public void setDosageTiming(String dosageTiming) {
        this.dosageTiming = dosageTiming;
    }
}
