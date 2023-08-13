package com.vishal.carRentalSystem.model;

import java.util.List;

public class Store {
    private int storeId;
    private Address address;
    private List<Vehicle> vehicleList;

    public Store(int storeId, Address address, List<Vehicle> vehicleList) {
        this.storeId = storeId;
        this.address = address;
        this.vehicleList = vehicleList;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
