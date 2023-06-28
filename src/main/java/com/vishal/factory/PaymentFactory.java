package com.vishal.factory;

import com.vishal.enums.PaymentMode;
import com.vishal.model.strategy.Payment;
import com.vishal.model.strategy.impl.CashPayment;
import com.vishal.model.strategy.impl.CreditCardPayment;

public class PaymentFactory {

    public static Payment createPaymentObject(PaymentMode paymentMode) {
        switch (paymentMode) {
            case CASH:
                return new CashPayment();
            case CREDIT_CARD:
                return new CreditCardPayment();
            default:
                // error invalid payment mode
                return null;
        }
    }
}
