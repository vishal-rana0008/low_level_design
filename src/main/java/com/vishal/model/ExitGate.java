package com.vishal.model;

import com.vishal.enums.PaymentMode;
import com.vishal.factory.PaymentFactory;
import com.vishal.model.strategy.FairCalculationStrategy;
import com.vishal.model.strategy.SpotStrategy;

import java.time.LocalDateTime;

public class ExitGate {
    private int id;

    private SpotStrategy spotStrategy;

    private FairCalculationStrategy fairCalculationStrategy;

    public ExitGate(int id, SpotStrategy spotStrategy, FairCalculationStrategy fairCalculationStrategy) {
        this.id = id;
        this.spotStrategy = spotStrategy;
        this.fairCalculationStrategy = fairCalculationStrategy;
    }

    public int getId() {
        return id;
    }

    public PaymentReceipt payTicket(Ticket ticket, PaymentMode paymentMode) {
        double fair = fairCalculationStrategy.calculateFair(ticket);

        spotStrategy.deallocateSpot(ticket.getAllottedSpot());

        PaymentReceipt paymentReceipt = new PaymentReceipt();
        paymentReceipt.setVehicle(ticket.getVehicle());
        paymentReceipt.setInTime(ticket.getInTime());
        paymentReceipt.setOutTime(LocalDateTime.now().getSecond());
        paymentReceipt.setEntryGateNo(ticket.getEntryGateNo());
        paymentReceipt.setExitGateNo(id);
        paymentReceipt.setFair(fair);

        boolean transactionSuccess = PaymentFactory.createPaymentObject(paymentMode)
                .initiatePayment(fair, paymentReceipt);

        if (transactionSuccess) {
            return paymentReceipt;
        } else {
            // throw payment failed exception
            return null;
        }

    }
}
