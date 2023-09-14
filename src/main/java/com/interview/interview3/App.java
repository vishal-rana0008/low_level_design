package com.interview.interview3;

import com.interview.interview3.enums.WorkoutType;
import com.interview.interview3.model.Slot;
import com.interview.interview3.model.Workout;
import com.interview.interview3.repository.BookingRepository;
import com.interview.interview3.repository.CenterDetailsRepository;
import com.interview.interview3.repository.CustomerRepository;
import com.interview.interview3.repository.WorkoutRepository;
import com.interview.interview3.service.BookingService;
import com.interview.interview3.service.CenterService;
import com.interview.interview3.service.CustomerService;
import com.interview.interview3.service.WorkoutService;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        BookingRepository bookingRepository = new BookingRepository();
        CenterDetailsRepository centerDetailsRepository = new CenterDetailsRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        WorkoutRepository workoutRepository = new WorkoutRepository();

        BookingService bookingService = new BookingService(bookingRepository);
        CenterService centerService = new CenterService(centerDetailsRepository);
        CustomerService customerService = new CustomerService(customerRepository);
        WorkoutService workoutService = new WorkoutService(workoutRepository);

        customerService.addCustomer("Aman");
        centerService.addCenter("Delhi");

        List<Slot> slots = new ArrayList<>();
        slots.add(new Slot(2, 3));
        centerService.addCenterTimings("Delhi", slots);

        List<WorkoutType> workoutList = new ArrayList<>();
        workoutList.add(WorkoutType.WEIGHTS);
        centerService.addCenterActivities("Delhi", workoutList);


    }
}
