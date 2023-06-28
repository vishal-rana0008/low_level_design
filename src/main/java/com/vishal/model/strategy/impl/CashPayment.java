package com.vishal.model.strategy.impl;

import com.vishal.model.PaymentReceipt;
import com.vishal.model.strategy.Payment;

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
