package com.vishal.carRentalSystem.service;

import com.vishal.carRentalSystem.model.User;
import com.vishal.carRentalSystem.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(int userId) throws Exception {
        return userRepository.getUser(userId);
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }
}
