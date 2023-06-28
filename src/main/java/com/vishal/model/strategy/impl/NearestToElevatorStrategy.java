package com.vishal.model.strategy.impl;

import com.vishal.enums.SpotType;
import com.vishal.model.Spot;
import com.vishal.model.Vehicle;
import com.vishal.model.strategy.SpotStrategy;

public class NearestToElevatorStrategy implements SpotStrategy {

    @Override
    public synchronized Spot getAvailableSpot(Vehicle vehicle, SpotType spotType) {
        return null;
    }

    @Override
    public synchronized void deallocateSpot(Spot spot) {

    }
}
