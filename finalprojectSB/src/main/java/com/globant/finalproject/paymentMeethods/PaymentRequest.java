package com.globant.finalproject.paymentMeethods;

public class PaymentRequest {

    private PaymentType type;

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public enum PaymentType {
        CC, PP;
    }
}
