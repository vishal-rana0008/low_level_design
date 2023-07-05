package com.vishal.parkingLot.factory;

import com.vishal.parkingLot.enums.SpotStrategyType;
import com.vishal.parkingLot.model.EntryGate;
import com.vishal.parkingLot.model.strategy.impl.LinearStrategy;
import com.vishal.parkingLot.model.strategy.impl.NearestToElevatorStrategy;
import com.vishal.parkingLot.model.strategy.impl.NearestToEntryGateStrategy;

import java.util.ArrayList;
import java.util.List;

public class EntryGatesFactory {

    public static List<EntryGate> createEntryGates(int noOfEntryGates, SpotStrategyType spotStrategyType,
                                                   int smallSpots, int mediumSpots, int largeSpots, int handicappedSpots) {
        LinearStrategy linearStrategy = new LinearStrategy(smallSpots, mediumSpots, largeSpots, handicappedSpots);
        NearestToElevatorStrategy nearestToElevatorStrategy = new NearestToElevatorStrategy();
        NearestToEntryGateStrategy nearestToEntryGateStrategy = new NearestToEntryGateStrategy();

        List<EntryGate> entryGates = new ArrayList<>();

        for (int i = 1; i <= noOfEntryGates; i++) {
            switch (spotStrategyType) {
                case LINEAR_STRATEGY:
                    entryGates.add(new EntryGate(i, linearStrategy));
                    break;
                case NEAREST_TO_ELEVATOR_STRATEGY:
                    entryGates.add(new EntryGate(i, nearestToElevatorStrategy));
                    break;
                case NEAREST_TO_ENTRY_GATE_STRATEGY:
                    entryGates.add(new EntryGate(i, nearestToEntryGateStrategy));
                    break;
            }
        }

        return entryGates;
    }
}
