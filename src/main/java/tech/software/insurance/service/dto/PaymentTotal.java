package tech.software.insurance.service.dto;

public class PaymentTotal {

    private Integer totalAmount;

    public PaymentTotal(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "PaymentTotal{" +
                "totalAmount=" + totalAmount +
                '}';
    }
}
