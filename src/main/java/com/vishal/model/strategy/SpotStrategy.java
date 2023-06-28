package com.vishal.model.strategy;

import com.vishal.enums.SpotType;
import com.vishal.model.Spot;
import com.vishal.model.Vehicle;

public interface SpotStrategy {
    Spot getAvailableSpot(Vehicle vehicle, SpotType spotType);
    void deallocateSpot(Spot spot);
}
