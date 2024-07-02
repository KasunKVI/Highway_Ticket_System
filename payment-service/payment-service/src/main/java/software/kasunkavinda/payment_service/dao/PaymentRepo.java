package software.kasunkavinda.payment_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.kasunkavinda.payment_service.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, String> {
}
