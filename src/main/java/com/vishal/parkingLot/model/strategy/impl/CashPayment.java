package com.vishal.parkingLot.model.strategy.impl;

import com.vishal.parkingLot.model.PaymentReceipt;
import com.vishal.parkingLot.model.strategy.Payment;

public class CashPayment implements Payment {

    @Override
    public boolean initiatePayment(double amt, PaymentReceipt paymentReceipt) {
        paymentReceipt.setTransactionId(null);
        return checkCashPaymentReceived(amt);
    }

    private boolean checkCashPaymentReceived(double amt) {
        return true;
    }
}
