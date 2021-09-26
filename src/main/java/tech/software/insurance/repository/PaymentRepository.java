package tech.software.insurance.repository;

import org.springframework.data.repository.CrudRepository;
import tech.software.insurance.domain.Payment;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
