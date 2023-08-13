package com.vishal.carRentalSystem.repository;

import com.vishal.carRentalSystem.model.Store;
import com.vishal.carRentalSystem.model.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreRepository {
    // storeId, Store - Map
    private Map<Integer, Store> storeList;

    // vehiclePlateNo, Vehicle - Map
    private Map<String, Vehicle> vehicleMap;

    public StoreRepository() {
        storeList = new HashMap<>();
        vehicleMap = new HashMap<>();
    }

    public void addVehicleInStore(int storeId, Vehicle vehicle) throws Exception {
        if (storeList.containsKey(storeId)) {
            Store store = storeList.get(storeId);
            store.getVehicleList().add(vehicle);
            vehicleMap.put(vehicle.getPlateNo(), vehicle);
        } else {
            throw new Exception("Store with storeId : " + storeId + " doesn't exist");
        }
    }

    public void addNewStore(Store store) throws Exception {
        if (!storeList.containsKey(store.getStoreId())) {
            storeList.put(store.getStoreId(), store);
        } else {
            throw new Exception("Store with storeId : " + store.getStoreId() + " already exist in system");
        }
    }

    public List<Store> findStoresInCity(String city) {
        return storeList.values().stream()
                .filter(store -> store.getAddress().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public Vehicle getVehicle(String vehiclePlateNo) {
        return vehicleMap.get(vehiclePlateNo);
    }
}
