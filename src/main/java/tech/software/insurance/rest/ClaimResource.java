package tech.software.insurance.rest;

import org.springframework.web.bind.annotation.*;
import tech.software.insurance.domain.Claim;
import tech.software.insurance.service.ClaimService;
import tech.software.insurance.service.dto.ClaimDTO;

@RestController
@RequestMapping("/api")
public class ClaimResource {
    private final ClaimService claimService;

    public ClaimResource(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/claim")
    public Claim claim(@RequestBody Claim claim) throws Exception {

        return claimService.claim(claim);
    }

    @PostMapping("/claim/approve")
    public Claim approve(@RequestBody ClaimDTO claimDTO) throws Exception {
        return claimService.approve(claimDTO.getClaimId());
    }

    @PostMapping("/claim/reject")
    public Claim reject(@RequestBody ClaimDTO claimDTO) throws Exception {
        return claimService.reject(claimDTO.getClaimId());
    }
}
