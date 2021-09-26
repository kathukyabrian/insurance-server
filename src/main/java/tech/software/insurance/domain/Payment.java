package tech.software.insurance.domain;

import tech.software.insurance.domain.enumerations.InsuranceType;
import tech.software.insurance.domain.enumerations.PaymentLength;
import tech.software.insurance.domain.enumerations.TransactionType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tbl_payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customerName;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentLength paymentLength;

    private LocalDate validityTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentLength getPaymentLength() {
        return paymentLength;
    }

    public void setPaymentLength(PaymentLength paymentLength) {
        this.paymentLength = paymentLength;
    }

    public LocalDate getValidityTo() {
        return validityTo;
    }

    public void setValidityTo(LocalDate validityTo) {
        this.validityTo = validityTo;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", insuranceType=" + insuranceType +
                ", transactionType=" + transactionType +
                ", paymentDate=" + paymentDate +
                ", paymentLength=" + paymentLength +
                ", validityTo=" + validityTo +
                '}';
    }
}
