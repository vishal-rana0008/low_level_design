package com.vishal.carRentalSystem.repository;

import com.vishal.carRentalSystem.model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepository {
    // userId, List of Bookings - Map
    private Map<Integer, List<Booking>> userBookings;

    public BookingRepository() {
        userBookings = new HashMap<>();
    }

    public void addBooking(Booking booking) {
        int userId = booking.getUser().getUserId();
        if (userBookings.containsKey(userId)) {
            userBookings.get(userId).add(booking);
        } else {
            List<Booking> userBooking = new ArrayList<>();
            userBooking.add(booking);
            userBookings.put(userId, userBooking);
        }
    }

    public List<Booking> getBookings(int userId) throws Exception {
        if (userBookings.containsKey(userId)) {
            return userBookings.get(userId);
        } else {
            throw new Exception("Bookings doesn't exist for userId : " + userId);
        }
    }
}
