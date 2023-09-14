package com.interview.interview3.service;

import com.interview.interview3.enums.WorkoutType;
import com.interview.interview3.model.Workout;
import com.interview.interview3.repository.WorkoutRepository;

import java.util.List;

public class WorkoutService {

    private WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public void addWorkout(Workout workout) {
        List<Workout> workoutList = workoutRepository.getWorkoutByTypeAndCenter(workout.getWorkoutType(), workout.getCenterName());

        // check if workout time doesnt overlap with center time

        workoutRepository.addWorkout(workout);
    }

    public List<Workout> viewWorkoutAvailability(WorkoutType workoutType) {
        return workoutRepository.getWorkoutByType(workoutType);
    }

    public List<Workout> viewWorkoutAvailability(WorkoutType workoutType, String centerName) {
        return workoutRepository.getWorkoutByTypeAndCenter(workoutType, centerName);
    }
}
