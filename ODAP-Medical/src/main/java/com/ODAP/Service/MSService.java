package com.ODAP.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODAP.Entity.MSEntity;
import com.ODAP.Repositery.MSRepositery;

@Service
public interface MSService {

    

    public MSEntity saveMSEntity(MSEntity msEntity);
      
    
    public List<MSEntity> getname(String patientName);
   
//    
//    public PaymentMedical savePayment(PaymentMedical payment);

}
