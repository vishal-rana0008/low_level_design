package com.vishal.model.strategy;

import com.vishal.model.Ticket;

public interface FairCalculationStrategy {
    double calculateFair(Ticket ticket);
}
