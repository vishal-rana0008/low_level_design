package com.vishal.parkingLot.model.strategy.impl;

import com.vishal.parkingLot.model.Ticket;
import com.vishal.parkingLot.model.strategy.FairCalculationStrategy;

public class CustomFairCalculationStrategy implements FairCalculationStrategy {

    @Override
    public double calculateFair(Ticket ticket) {
        // calculate custom fair
        return 0;
    }
}
