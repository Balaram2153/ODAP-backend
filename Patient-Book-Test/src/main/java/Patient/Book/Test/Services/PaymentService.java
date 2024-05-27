package Patient.Book.Test.Services;

import java.util.List;

import Patient.Book.Test.enity.PaymentDetails;

public interface PaymentService {
    PaymentDetails savePaymentDetails(PaymentDetails paymentDetails);
    
    List<PaymentDetails> getallpayments();
}

