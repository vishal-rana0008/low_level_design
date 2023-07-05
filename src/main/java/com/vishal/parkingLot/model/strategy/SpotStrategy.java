package com.vishal.parkingLot.model.strategy;

import com.vishal.parkingLot.enums.SpotType;
import com.vishal.parkingLot.model.Spot;
import com.vishal.parkingLot.model.Vehicle;

public interface SpotStrategy {
    Spot getAvailableSpot(Vehicle vehicle, SpotType spotType);
    void deallocateSpot(Spot spot);
}
