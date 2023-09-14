package com.interview.interview1.respository;

import com.interview.interview1.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDetailsRepository {
    // userId, User
    Map<String, User> userRepoMap;

    public Map<String, User> getUserRepoMap() {
        return userRepoMap;
    }

    public void addUser(User user) {
        userRepoMap.put(user.getUserId(), user);
    }

    public UserDetailsRepository() {
        userRepoMap = new HashMap<>();
    }
}
