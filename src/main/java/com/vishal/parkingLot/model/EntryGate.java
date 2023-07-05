package com.vishal.parkingLot.model;

import com.vishal.parkingLot.enums.SpotType;
import com.vishal.parkingLot.model.strategy.SpotStrategy;

import java.time.LocalDateTime;

public class EntryGate {
    private int id;

    private SpotStrategy spotStrategy;

    public EntryGate(int id, SpotStrategy spotStrategy) {
        this.id = id;
        this.spotStrategy = spotStrategy;
    }

    public int getId() {
        return id;
    }

    public SpotStrategy getSpotStrategy() {
        return spotStrategy;
    }

    public Ticket assignTicket(Vehicle vehicle, SpotType spotType) {
        Spot spot = spotStrategy.getAvailableSpot(vehicle, spotType);
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setAllottedSpot(spot);
        ticket.setInTime(LocalDateTime.now().getSecond());
        ticket.setEntryGateNo(id);
        return ticket;
    }
}
