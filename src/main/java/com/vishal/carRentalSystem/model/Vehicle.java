package com.vishal.carRentalSystem.model;

import com.vishal.carRentalSystem.enums.VehicleColor;
import com.vishal.carRentalSystem.enums.VehicleType;

public class Vehicle {
    private String plateNo;
    private String model;
    private String company;
    private VehicleColor color;
    private VehicleType type;
    private boolean isBooked;
    private double pricePerHour;

    public Vehicle(String plateNo, String model, String company, VehicleColor color, VehicleType type, boolean isBooked, double pricePerHour) {
        this.plateNo = plateNo;
        this.model = model;
        this.company = company;
        this.color = color;
        this.type = type;
        this.isBooked = isBooked;
        this.pricePerHour = pricePerHour;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public VehicleColor getColor() {
        return color;
    }

    public void setColor(VehicleColor color) {
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNo='" + plateNo + '\'' +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", color=" + color +
                ", type=" + type +
                ", isBooked=" + isBooked +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
