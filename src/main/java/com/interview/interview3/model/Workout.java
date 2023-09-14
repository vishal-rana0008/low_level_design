package com.interview.interview3.model;

import com.interview.interview3.enums.WorkoutType;

import java.util.concurrent.ThreadLocalRandom;

public class Workout {
    private int workoutId;
    private String centerName;
    private WorkoutType workoutType;
    private Slot slot;
    private int availableSeats;

    public Workout(String centerName, WorkoutType workoutType, Slot slot, int availableSeats) {
        this.workoutId = ThreadLocalRandom.current().nextInt();
        this.centerName = centerName;
        this.workoutType = workoutType;
        this.slot = slot;
        this.availableSeats = availableSeats;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
