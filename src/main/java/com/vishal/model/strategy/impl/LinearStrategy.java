package com.vishal.model.strategy.impl;

import com.vishal.enums.SpotType;
import com.vishal.model.Spot;
import com.vishal.model.Vehicle;
import com.vishal.model.strategy.SpotStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinearStrategy implements SpotStrategy {
    private Map<SpotType, List<Spot>> availableSpots;
    private Map<SpotType, List<Spot>> allocatedSpots;
    private static final int MAX_CAPACITY = 10000;
    private int capacity;

    public LinearStrategy( int small, int medium, int large, int handicapped) {
        this.capacity = small + medium + large + handicapped;
        availableSpots = new HashMap<>();
        allocatedSpots = new HashMap<>();

        List<Spot> smallSpots = new ArrayList<>();
        for (int i = 1; i <= small; i++) {
            smallSpots.add(new Spot(SpotType.SMALL));
        }
        availableSpots.put(SpotType.SMALL, smallSpots);

        List<Spot> mediumSpots = new ArrayList<>();
        for (int i = 1; i <= medium; i++) {
            mediumSpots.add(new Spot(SpotType.MEDIUM));
        }
        availableSpots.put(SpotType.MEDIUM, mediumSpots);

        List<Spot> largeSpots = new ArrayList<>();
        for (int i = 1; i <= large; i++) {
            largeSpots.add(new Spot(SpotType.LARGE));
        }
        availableSpots.put(SpotType.LARGE, largeSpots);

        List<Spot> handicappedSpots = new ArrayList<>();
        for (int i = 1; i <= handicapped; i++) {
            handicappedSpots.add(new Spot(SpotType.HANDICAPPED));
        }
        availableSpots.put(SpotType.HANDICAPPED, handicappedSpots);
    }

    @Override
    public synchronized Spot getAvailableSpot(Vehicle vehicle, SpotType spotType) {
        if (availableSpots.size() == 0) {
            // throw exception
        }

        Spot spot = availableSpots.get(spotType).remove(availableSpots.get(spotType).size() - 1);
        if (allocatedSpots.get(spotType) == null) {
            allocatedSpots.put(spotType, new ArrayList<>());
        }
        allocatedSpots.get(spotType).add(spot);
        return spot;
    }

    @Override
    public synchronized void deallocateSpot(Spot spot) {
        allocatedSpots.get(spot.getSpotType()).remove(spot);
        availableSpots.get(spot.getSpotType()).add(spot);
    }
}
