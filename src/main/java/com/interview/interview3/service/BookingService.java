package com.interview.interview3.service;

import com.interview.interview3.model.Booking;
import com.interview.interview3.model.Workout;
import com.interview.interview3.repository.BookingRepository;
import com.interview.interview3.repository.WorkoutRepository;

import java.util.List;

public class BookingService {

    private BookingRepository bookingRepository;

    private WorkoutRepository workoutRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void addBooking(Booking booking) {
        List<Workout> workoutList = workoutRepository.getWorkoutByTypeAndCenter(booking.getWorkoutType(), booking.getCenterName());

        Workout workout = workoutList.stream().filter(workout1 -> workout1.getSlot().getStart() == booking.getSlot().getStart() && workout1.getSlot().getEnd() == booking.getSlot().getEnd()).findFirst().orElse(null);

        synchronized (workout) {
            workout.setAvailableSeats(workout.getAvailableSeats() - 1);
            bookingRepository.addBooking(booking);
        }
    }
}
