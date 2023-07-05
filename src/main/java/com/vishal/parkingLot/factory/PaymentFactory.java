package com.vishal.parkingLot.factory;

import com.vishal.parkingLot.enums.PaymentMode;
import com.vishal.parkingLot.model.strategy.Payment;
import com.vishal.parkingLot.model.strategy.impl.CashPayment;
import com.vishal.parkingLot.model.strategy.impl.CreditCardPayment;

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
