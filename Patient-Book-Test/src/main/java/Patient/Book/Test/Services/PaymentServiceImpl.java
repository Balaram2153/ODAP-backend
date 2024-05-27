package Patient.Book.Test.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Patient.Book.Test.Repositary.PaymentDetailsRepository;
import Patient.Book.Test.enity.PaymentDetails;

@Service
public class PaymentServiceImpl implements PaymentService {
	

    private final PaymentDetailsRepository paymentDetailsRepository;
    

    @Autowired
    public PaymentServiceImpl(PaymentDetailsRepository paymentDetailsRepository) {
        this.paymentDetailsRepository = paymentDetailsRepository;
    }

    @Override
    public PaymentDetails savePaymentDetails(PaymentDetails paymentDetails) {
        return paymentDetailsRepository.save(paymentDetails);
    }

	@Override
	public List<PaymentDetails> getallpayments() {
		// TODO Auto-generated method stub
		return paymentDetailsRepository.findAll();
	}
    
    
}
