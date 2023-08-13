package com.vishal.carRentalSystem.service;

import com.vishal.carRentalSystem.model.Store;
import com.vishal.carRentalSystem.model.Vehicle;
import com.vishal.carRentalSystem.repository.StoreRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Vehicle> searchVehicle(String city, String model, double maxPricePerHour) throws Exception {
        if (city.isEmpty()) {
            throw new Exception("City shouldn't be empty");
        }

        List<Store> storeList = storeRepository.findStoresInCity(city);

        List<Vehicle> vehicles = storeList.stream()
                .map(Store::getVehicleList)
                .flatMap(vehicleList -> vehicleList.stream())
                .collect(Collectors.toList());

        return vehicles.stream()
                    .filter(vehicle -> model.isEmpty() || vehicle.getModel().equalsIgnoreCase(model))
                    .filter(vehicle -> Double.compare(vehicle.getPricePerHour(), maxPricePerHour) <= 0)
                    .collect(Collectors.toList());
    }

    public Vehicle getVehicle(String vehiclePlateNo) {
        return storeRepository.getVehicle(vehiclePlateNo);
    }

    public void addNewStore(Store store) throws Exception {
        storeRepository.addNewStore(store);
    }

    public void addVehicleInStore(int storeId, Vehicle vehicle) throws Exception {
        storeRepository.addVehicleInStore(storeId, vehicle);
    }
}
