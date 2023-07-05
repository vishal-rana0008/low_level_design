package com.vishal.parkingLot.model.strategy.impl;

import com.vishal.parkingLot.model.Ticket;
import com.vishal.parkingLot.model.strategy.FairCalculationStrategy;

import java.time.LocalDateTime;

public class HourlyFairCalculationStrategy implements FairCalculationStrategy {

    private final double hourlyRate = 20.00;

    @Override
    public double calculateFair(Ticket ticket) {
        double hours = LocalDateTime.now().getSecond() - ticket.getInTime();
        return hours * hourlyRate;
    }
}
