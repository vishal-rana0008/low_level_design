package com.vishal.parkingLot.model;

import com.vishal.parkingLot.enums.VehicleType;

public class Vehicle {
    private String vehicleNo;
    private String customerName;
    private VehicleType vehicleType;

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
