package com.interview.interview3.repository;

import com.interview.interview3.model.CenterDetails;

import java.util.HashMap;
import java.util.Map;

public class CenterDetailsRepository {
    // centerName, CenterDetails
    private Map<String, CenterDetails> centerDetailsMap = new HashMap<>();

    public void addCenter(String centerName) {
        centerDetailsMap.put(centerName, new CenterDetails(centerName));
    }

    public void updateCenterDetails(CenterDetails centerDetails) {
        centerDetailsMap.put(centerDetails.getCenterName(), centerDetails);
    }

    public CenterDetails getCenterDetails(String centerName) {
        return centerDetailsMap.get(centerName);
    }
}
