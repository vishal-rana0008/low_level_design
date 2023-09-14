package com.interview.interview3.model;

import com.interview.interview3.enums.WorkoutType;

import java.util.concurrent.ThreadLocalRandom;

public class Booking {
    private int bookingId;
    private String customerName;
    private String centerName;
    private WorkoutType workoutType;
    private Slot slot;

    public Booking(String customerName, String centerName, WorkoutType workoutType, Slot slot) {
        this.bookingId = ThreadLocalRandom.current().nextInt();
        this.customerName = customerName;
        this.centerName = centerName;
        this.workoutType = workoutType;
        this.slot = slot;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
}
