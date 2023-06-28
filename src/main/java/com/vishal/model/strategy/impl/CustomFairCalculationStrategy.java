package com.vishal.model.strategy.impl;

import com.vishal.model.Ticket;
import com.vishal.model.strategy.FairCalculationStrategy;

public class CustomFairCalculationStrategy implements FairCalculationStrategy {

    @Override
    public double calculateFair(Ticket ticket) {
        // calculate custom fair
        return 0;
    }
}
