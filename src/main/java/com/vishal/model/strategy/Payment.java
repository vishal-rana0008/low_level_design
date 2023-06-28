package com.vishal.model.strategy;

import com.vishal.model.PaymentReceipt;

public interface Payment {
    boolean initiatePayment(double amt, PaymentReceipt paymentReceipt);
}
