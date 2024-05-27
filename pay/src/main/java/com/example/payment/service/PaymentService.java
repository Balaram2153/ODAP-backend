package com.example.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(String paymentid) {
        return paymentRepository.findById(paymentid);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(String paymentid, Payment updatedPayment) {
        updatedPayment.setPaymentid(paymentid); // Set the ID of the updated payment
        return paymentRepository.save(updatedPayment);
    }

    public void deletePayment(String paymentid) {
        paymentRepository.deleteById(paymentid);
    }
    

}
