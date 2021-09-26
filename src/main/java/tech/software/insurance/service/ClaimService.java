package tech.software.insurance.service;

import org.springframework.stereotype.Service;
import tech.software.insurance.domain.Claim;
import tech.software.insurance.domain.Payment;
import tech.software.insurance.domain.enumerations.ClaimStatus;
import tech.software.insurance.repository.ClaimRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;

    private final PaymentService paymentService;

    public ClaimService(ClaimRepository claimRepository, PaymentService paymentService) {
        this.claimRepository = claimRepository;
        this.paymentService = paymentService;
    }

    public Claim claim(Claim claim) throws Exception {

        Payment payment = paymentService.getOne(claim.getPaymentId());

        // check if expired
        if(payment.getValidityTo().isBefore(LocalDate.now())){
            throw new Exception("The payment has expired");
        }
        claim.setClaimStatus(ClaimStatus.PENDING);

        return claimRepository.save(claim);
    }

    public Claim approve(Integer id) throws Exception {
        Claim claim = findOne(id);

        claim.setClaimStatus(ClaimStatus.RESOLVED);

        Payment payment = paymentService.getOne(claim.getPaymentId());

        paymentService.disburse(payment);

        return claimRepository.save(claim);
    }

    public Claim reject(Integer id) throws Exception {
        Claim claim = findOne(id);

        claim.setClaimStatus(ClaimStatus.FAILED);

        return claimRepository.save(claim);
    }

    public Claim findOne(Integer id) throws Exception {
        Optional<Claim> optionalClaim = claimRepository.findById(id);

        if(optionalClaim.isPresent()){
            return optionalClaim.get();
        }else{
            throw new Exception("Claim not found");
        }
    }
}
