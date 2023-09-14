package com.interview.interview3.service;

import com.interview.interview3.enums.WorkoutType;
import com.interview.interview3.model.CenterDetails;
import com.interview.interview3.model.Slot;
import com.interview.interview3.repository.CenterDetailsRepository;

import java.util.List;
import java.util.Objects;

public class CenterService {

    private CenterDetailsRepository centerDetailsRepository;

    public CenterService(CenterDetailsRepository centerDetailsRepository) {
        this.centerDetailsRepository = centerDetailsRepository;
    }

    public void addCenter(String centerName) throws Exception {
        if (Objects.isNull(centerDetailsRepository.getCenterDetails(centerName))) {
            centerDetailsRepository.addCenter(centerName);
        } else {
            throw new Exception("center already present");
        }
    }

    public void addCenterTimings(String centerName, List<Slot> openTimingSlots) throws Exception {
        CenterDetails centerDetails = centerDetailsRepository.getCenterDetails(centerName);

        if (Objects.nonNull(centerDetails)) {
            openTimingSlots.stream().forEach(slot -> {
                // check if slots don't overlap
            });
            centerDetails.setOpenTimings(openTimingSlots);
            centerDetailsRepository.updateCenterDetails(centerDetails);
        } else {
            throw new Exception("center doesn't exist");
        }
    }

    public void addCenterActivities(String centerName, List<WorkoutType> activities) throws Exception {
        CenterDetails centerDetails = centerDetailsRepository.getCenterDetails(centerName);

        if (Objects.nonNull(centerDetails)) {
            centerDetails.setActivities(activities);
        } else {
            throw new Exception("center doesn't exist");
        }
    }
}
