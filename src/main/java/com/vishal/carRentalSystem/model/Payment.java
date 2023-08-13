package com.vishal.carRentalSystem.model;

import com.vishal.carRentalSystem.enums.PaymentStatus;

public class Payment {
    private int paymentId;
    private PaymentStatus paymentStatus;
    private double amt;

    public Payment(int paymentId, PaymentStatus paymentStatus, double amt) {
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
        this.amt = amt;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}
