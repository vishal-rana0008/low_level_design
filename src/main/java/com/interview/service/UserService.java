package com.interview.service;

import com.interview.model.Cart;
import com.interview.model.User;
import com.interview.respository.CartRepository;
import com.interview.respository.UserDetailsRepository;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class UserService {

    private UserDetailsRepository userDetailsRepository;

    private CartRepository cartRepository;

    public UserService(UserDetailsRepository userDetailsRepository, CartRepository cartRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.cartRepository = cartRepository;
    }

    public void createUser(User user) throws Exception {
        validateUserDetails(user);
        user.setUserId(Integer.toString(ThreadLocalRandom.current().nextInt()));
        userDetailsRepository.addUser(user);
        cartRepository.getcartRepoMap().put(user.getUserId(), new Cart());
    }

    public User getUser(String userId) throws Exception {
        User user = userDetailsRepository.getUserRepoMap().get(userId);
        if (Objects.isNull(user)) {
            throw new Exception("User not found");
        }
        return user;
    }

    private void validateUserDetails(User user) throws Exception {
        String errorMsg = "Following user details are invalid : ";
        int errCnt = 0;
        if (user.getName().isEmpty()) {
            errorMsg += "name";
            errCnt++;
        }
        if (user.getEmail().isEmpty()) {
            errorMsg += ",email";
            errCnt++;
        }
        if (user.getPassword().isEmpty()) {
            errorMsg += ",password";
            errCnt++;
        }

        if (errCnt > 0) {
            throw new Exception(errorMsg);
        }
    }
}
