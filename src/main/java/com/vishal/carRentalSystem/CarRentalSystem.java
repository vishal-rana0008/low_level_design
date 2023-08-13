package com.vishal.carRentalSystem;

import com.vishal.carRentalSystem.enums.BookingType;
import com.vishal.carRentalSystem.model.Booking;
import com.vishal.carRentalSystem.model.Store;
import com.vishal.carRentalSystem.model.User;
import com.vishal.carRentalSystem.model.Vehicle;
import com.vishal.carRentalSystem.repository.BookingRepository;
import com.vishal.carRentalSystem.repository.StoreRepository;
import com.vishal.carRentalSystem.repository.UserRepository;
import com.vishal.carRentalSystem.service.BookingService;
import com.vishal.carRentalSystem.service.PaymentService;
import com.vishal.carRentalSystem.service.StoreService;
import com.vishal.carRentalSystem.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

public class CarRentalSystem {
    private static CarRentalSystem carRentalSystem = null;

    private BookingService bookingService;

    private PaymentService paymentService;

    private StoreService storeService;

    private UserService userService;

    private CarRentalSystem() {
        BookingRepository bookingRepository = new BookingRepository();
        StoreRepository storeRepository = new StoreRepository();
        UserRepository userRepository = new UserRepository();

        userService = new UserService(userRepository);
        storeService = new StoreService(storeRepository);
        paymentService = new PaymentService(userService);
        bookingService = new BookingService(bookingRepository, storeService, userService, paymentService);
    }

    public synchronized static CarRentalSystem getInstance() {
        if (carRentalSystem == null) {
            carRentalSystem = new CarRentalSystem();
        }
        return carRentalSystem;
    }

    public User getUser(int userId) throws Exception {
        return userService.getUser(userId);
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public List<Vehicle> searchVehicle(String city, String model, double maxPricePerHour) throws Exception {
        return storeService.searchVehicle(city, model, maxPricePerHour);
    }

    public Vehicle getVehicle(String vehiclePlateNo) {
        return storeService.getVehicle(vehiclePlateNo);
    }

    public void addNewStore(Store store) throws Exception {
        storeService.addNewStore(store);
    }

    public void addVehicleInStore(int storeId, Vehicle vehicle) throws Exception {
        storeService.addVehicleInStore(storeId, vehicle);
    }

    public Booking bookVehicle(String vehiclePlateNo, int userId, LocalDateTime timeBookedTill, BookingType bookingType) throws Exception {
        return bookingService.bookVehicle(vehiclePlateNo, userId, timeBookedTill, bookingType);
    }

    public Booking returnVehicle(String vehiclePlateNo, int userId, int bookingId) throws Exception {
        return bookingService.returnVehicle(vehiclePlateNo, userId, bookingId);
    }
}
