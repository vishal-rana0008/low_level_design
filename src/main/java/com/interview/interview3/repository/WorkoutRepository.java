package com.interview.interview3.repository;

import com.interview.interview3.enums.WorkoutType;
import com.interview.interview3.model.Workout;

import java.util.*;

public class WorkoutRepository {
                            // centerName
    private Map<WorkoutType, Map<String, List<Workout>>> workoutTypeListMap = new HashMap<>();

    public List<Workout> getWorkoutByTypeAndCenter(WorkoutType workoutType, String centerName) {
        return workoutTypeListMap.get(workoutType).get(centerName);
    }

    public List<Workout> getWorkoutByType(WorkoutType workoutType) {
        List<Workout> result = new ArrayList<>();
        workoutTypeListMap.get(workoutType).values()
                .forEach(result::addAll);
        return result;
    }

    public void addWorkout(Workout workout) {
        if (workoutTypeListMap.containsKey(workout.getWorkoutType())) {
            Map<String, List<Workout>> centerWorkouts = workoutTypeListMap.get(workout.getWorkoutType());
            if (centerWorkouts.containsKey(workout.getCenterName())) {
                centerWorkouts.get(workout.getCenterName()).add(workout);
            } else {
                List<Workout> workoutList = new ArrayList<>();
                workoutList.add(workout);
                centerWorkouts.put(workout.getCenterName(), workoutList);
            }
        } else {
            Map<String, List<Workout>> centerWorkouts = new HashMap<>();
            List<Workout> workoutList = new ArrayList<>();
            workoutList.add(workout);

            centerWorkouts.put(workout.getCenterName(), workoutList);
            workoutTypeListMap.put(workout.getWorkoutType(), centerWorkouts);
        }
    }

    public void updateWorkout(Workout workout) {

    }
}
