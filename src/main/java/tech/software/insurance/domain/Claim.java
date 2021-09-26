package tech.software.insurance.domain;

import tech.software.insurance.domain.enumerations.ClaimStatus;

import javax.persistence.*;

@Entity
@Table(name="tbl_claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer paymentId;

    private String reason;

    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", paymentId=" + paymentId +
                ", reason='" + reason + '\'' +
                ", claimStatus=" + claimStatus +
                '}';
    }
}
