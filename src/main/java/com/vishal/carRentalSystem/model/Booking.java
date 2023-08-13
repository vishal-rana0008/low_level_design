package com.vishal.carRentalSystem.model;

import com.vishal.carRentalSystem.enums.BookingType;

import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingType bookingType;
    private Payment payment;

    public Booking(int bookingId, User user, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime, BookingType bookingType, Payment payment) {
        this.bookingId = bookingId;
        this.user = user;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingType = bookingType;
        this.payment = payment;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", bookingType=" + bookingType +
                ", payment=" + payment +
                '}';
    }
}
