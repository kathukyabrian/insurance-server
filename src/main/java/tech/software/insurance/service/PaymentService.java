package tech.software.insurance.service;

import org.springframework.stereotype.Service;
import tech.software.insurance.domain.Payment;
import tech.software.insurance.domain.enumerations.PaymentLength;
import tech.software.insurance.domain.enumerations.TransactionType;
import tech.software.insurance.repository.PaymentRepository;
import tech.software.insurance.service.dto.PaymentTotal;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    // save a payment

    public Payment pay(Payment payment){
        // we will need to call

        payment.setPaymentDate(LocalDate.now());

        payment.setValidityTo(resolveEndDate(payment.getPaymentLength()));

        payment.setTransactionType(TransactionType.CREDIT);

        return paymentRepository.save(payment);
    }

    public Payment disburse(Payment payment){
        payment.setTransactionType(TransactionType.DEBIT);

        return paymentRepository.save(payment);
    }

    public PaymentTotal calculateTotal(){
        int total = 0;

        for(Payment payment : paymentRepository.findAll()){
            if(payment.getTransactionType()==TransactionType.CREDIT){
                total += payment.getAmount();
            }else{
                total -= payment.getAmount();
            }
        }

        PaymentTotal paymentTotal = new PaymentTotal(total);

        return paymentTotal;
    }

    public LocalDate resolveEndDate(PaymentLength paymentLength){
        if(paymentLength==PaymentLength.MONTHLY){
            return LocalDate.now().plusDays(30);
        }else if(paymentLength==PaymentLength.YEARLY){
            return LocalDate.now().plusYears(1);
        }else{
            return null;
        }
    }


    public Payment getOne(Integer id) throws Exception {

        Optional<Payment> optionalPayment = paymentRepository.findById(id);

        if(optionalPayment.isPresent()){
            return optionalPayment.get();
        }else{
            throw new Exception("Payment not found");
        }
    }

}
