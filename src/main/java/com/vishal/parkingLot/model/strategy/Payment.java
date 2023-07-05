package com.vishal.parkingLot.model.strategy;

import com.vishal.parkingLot.model.PaymentReceipt;

public interface Payment {
    boolean initiatePayment(double amt, PaymentReceipt paymentReceipt);
}
