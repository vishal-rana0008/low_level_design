package com.vishal.carRentalSystem.service;

import com.vishal.carRentalSystem.enums.PaymentStatus;
import com.vishal.carRentalSystem.model.Payment;
import com.vishal.carRentalSystem.model.User;

import java.util.concurrent.ThreadLocalRandom;

public class PaymentService {

    private UserService userService;

    public PaymentService(UserService userService) {
        this.userService = userService;
    }

    public Payment doPayment(int userId, double paymentAmt) throws Exception {
        User user = userService.getUser(userId);
        if (user.getAccountBalance() >= paymentAmt) {
            user.reduceAccountBalance(paymentAmt);
            int paymentId = ThreadLocalRandom.current().nextInt();
            Payment payment = new Payment(paymentId, PaymentStatus.SUCCESSFUL, paymentAmt);
            return payment;
        } else {
            throw new Exception("Insufficient balance in account of userId : " + userId);
        }
    }
}
