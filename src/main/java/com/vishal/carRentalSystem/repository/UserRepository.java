package com.vishal.carRentalSystem.repository;

import com.vishal.carRentalSystem.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    // userId, User - Map
    private Map<Integer, User> userMap;

    public UserRepository() {
        userMap = new HashMap<>();
    }

    public User getUser(int userId) throws Exception {
        if (userMap.containsKey(userId))
            return userMap.get(userId);
        else
            throw new Exception("User doesn't exist");
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }
}
