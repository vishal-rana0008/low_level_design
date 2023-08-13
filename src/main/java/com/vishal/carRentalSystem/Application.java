package com.vishal.carRentalSystem;

import com.vishal.carRentalSystem.enums.BookingType;
import com.vishal.carRentalSystem.enums.VehicleColor;
import com.vishal.carRentalSystem.enums.VehicleType;
import com.vishal.carRentalSystem.model.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        try {
            CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();

            carRentalSystem.addUser(new User(1, "Aman", "cont1", "l1", new Address("s1", "c1", "s1"), 10000.00));
            carRentalSystem.addUser(new User(2, "Shyam", "cont2", "l2", new Address("s2", "c2", "s2"), 15000.00));

            carRentalSystem.addNewStore(new Store(1, new Address("sohna", "gurugram", "haryana"), new ArrayList<>()));
            carRentalSystem.addVehicleInStore(1, new Vehicle("p1", "900 cc", "Hyundai", VehicleColor.RED, VehicleType.CAR, false, 300.00));
            carRentalSystem.addVehicleInStore(1, new Vehicle("p2", "1500 cc", "Tata", VehicleColor.BLACK, VehicleType.CAR, false, 500.00));
            carRentalSystem.addVehicleInStore(1, new Vehicle("p3", "2000 cc", "Maruti", VehicleColor.WHITE, VehicleType.CAR, false, 800.00));

            carRentalSystem.addNewStore(new Store(2, new Address("karol bagh", "delhi", "delhi"), new ArrayList<>()));
            carRentalSystem.addVehicleInStore(2, new Vehicle("p9", "400 cc", "Porsh", VehicleColor.RED, VehicleType.CAR, false, 2000.00));

            System.out.println(carRentalSystem.searchVehicle("gurugram", "1500 cc", 600.00));

            System.out.println(carRentalSystem.getUser(1));

            Booking booking = carRentalSystem.bookVehicle("p2", 1, LocalDateTime.of(2023, Month.AUGUST, 14, 10, 0), BookingType.PAY_AT_TIME_OF_BOOKING);
            System.out.println(booking);

            Booking finalBooking = carRentalSystem.returnVehicle("p2", 1, booking.getBookingId());
            System.out.println(finalBooking);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
