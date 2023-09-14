package com.interview.interview3.repository;

import com.interview.interview3.model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    // BookingId, booking
    private Map<Integer, Booking> bookingMap = new HashMap<>();

    public void addBooking(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
    }

    public void removeBooking(int bookingId) {
        bookingMap.remove(bookingId);
    }
}
