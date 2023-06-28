package com.vishal.model.strategy.impl;

import com.vishal.model.PaymentReceipt;
import com.vishal.model.strategy.Payment;

public class CreditCardPayment implements Payment {

    @Override
    public boolean initiatePayment(double amt, PaymentReceipt paymentReceipt) {
        paymentReceipt.setTransactionId("xyz");
        return swapCreditCardAndReceivePayment(amt);
    }

    private boolean swapCreditCardAndReceivePayment(double amt) {
        return true;
    }
}
