package com.vishal.parkingLot.model.strategy.impl;

import com.vishal.parkingLot.enums.SpotType;
import com.vishal.parkingLot.model.Spot;
import com.vishal.parkingLot.model.Vehicle;
import com.vishal.parkingLot.model.strategy.SpotStrategy;

public class NearestToElevatorStrategy implements SpotStrategy {

    @Override
    public synchronized Spot getAvailableSpot(Vehicle vehicle, SpotType spotType) {
        return null;
    }

    @Override
    public synchronized void deallocateSpot(Spot spot) {

    }
}
