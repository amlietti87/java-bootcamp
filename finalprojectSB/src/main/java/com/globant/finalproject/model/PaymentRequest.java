package com.globant.finalproject.model;

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
