package software.kasunkavinda.payment_service.service;

import software.kasunkavinda.payment_service.dto.PaymentDTO;

public interface PaymentService {

    String makePayment(PaymentDTO paymentDTO);
    void removePayment(String id);
    PaymentDTO getPayment(String id);
    String updatePayment(PaymentDTO paymentDTO);


}
