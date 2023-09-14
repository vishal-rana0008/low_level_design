package com.interview.interview3.model;

import com.interview.interview3.enums.WorkoutType;

import java.util.List;

public class CenterDetails {
    private String centerName;
    private List<Slot> openTimings;
    private List<WorkoutType> activities;

    public CenterDetails(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public List<Slot> getOpenTimings() {
        return openTimings;
    }

    public void setOpenTimings(List<Slot> openTimings) {
        this.openTimings = openTimings;
    }

    public List<WorkoutType> getActivities() {
        return activities;
    }

    public void setActivities(List<WorkoutType> activities) {
        this.activities = activities;
    }
}
