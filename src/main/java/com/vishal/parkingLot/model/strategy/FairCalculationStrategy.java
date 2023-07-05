package com.vishal.parkingLot.model.strategy;

import com.vishal.parkingLot.model.Ticket;

public interface FairCalculationStrategy {
    double calculateFair(Ticket ticket);
}
