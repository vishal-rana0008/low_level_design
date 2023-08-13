package com.vishal.carRentalSystem.service;

import com.vishal.carRentalSystem.enums.BookingType;
import com.vishal.carRentalSystem.model.Booking;
import com.vishal.carRentalSystem.model.Payment;
import com.vishal.carRentalSystem.model.User;
import com.vishal.carRentalSystem.model.Vehicle;
import com.vishal.carRentalSystem.repository.BookingRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class BookingService {

    private BookingRepository bookingRepository;

    private StoreService storeService;

    private UserService userService;

    private PaymentService paymentService;

    public BookingService(BookingRepository bookingRepository, StoreService storeService, UserService userService, PaymentService paymentService) {
        this.bookingRepository = bookingRepository;
        this.storeService = storeService;
        this.userService = userService;
        this.paymentService = paymentService;
    }

    public Booking bookVehicle(String vehiclePlateNo, int userId, LocalDateTime timeBookedTill, BookingType bookingType) throws Exception {
        Vehicle vehicle = storeService.getVehicle(vehiclePlateNo);
        User user = userService.getUser(userId);

        Payment payment = null;
        if (bookingType == BookingType.PAY_AT_TIME_OF_BOOKING) {
            double paymentAmt = Duration.between(LocalDateTime.now(), timeBookedTill).toHours() * vehicle.getPricePerHour();
            payment = paymentService.doPayment(userId, paymentAmt);
        }

        vehicle.setBooked(true);
        int bookingId = ThreadLocalRandom.current().nextInt();
        Booking booking = new Booking(bookingId, user, vehicle, LocalDateTime.now(), timeBookedTill, bookingType, payment);

        bookingRepository.addBooking(booking);

        return booking;
    }

    public Booking returnVehicle(String vehiclePlateNo, int userId, int bookingId) throws Exception {
        Vehicle vehicle = storeService.getVehicle(vehiclePlateNo);

        Booking booking = bookingRepository.getBookings(userId).stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(booking)) {
            if (booking.getBookingType() == BookingType.PAY_ON_VEHICLE_RETURN) {
                double paymentAmt = Duration.between(booking.getStartTime(), booking.getEndTime()).toHours() * vehicle.getPricePerHour();
                Payment payment = paymentService.doPayment(userId, paymentAmt);
                booking.setPayment(payment);
            }
        }

        vehicle.setBooked(false);

        return booking;
    }
}
