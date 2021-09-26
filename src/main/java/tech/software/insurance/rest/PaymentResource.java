package tech.software.insurance.rest;

import org.springframework.web.bind.annotation.*;
import tech.software.insurance.domain.Payment;
import tech.software.insurance.service.PaymentService;
import tech.software.insurance.service.dto.PaymentTotal;

@RestController
@RequestMapping("/api")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public Payment pay(@RequestBody Payment payment){

        return paymentService.pay(payment);
    }

    @PostMapping("/payment/disburse")
    public Payment disburse (@RequestBody Payment payment){

        return paymentService.disburse(payment);
    }

    @GetMapping("/payment-total")
    public PaymentTotal getTotal(){
        return paymentService.calculateTotal();
    }
}
