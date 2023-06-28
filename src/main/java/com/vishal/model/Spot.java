package com.vishal.model;

import com.vishal.enums.SpotType;

public class Spot {
    private int id;
    private SpotType spotType;

    public Spot(SpotType spotType) {
        this.id = (int) (Math.random() * 100);
        this.spotType = spotType;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", spotType=" + spotType +
                '}';
    }
}
