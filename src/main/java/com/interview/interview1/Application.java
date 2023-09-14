package com.interview.interview1;

import com.interview.interview1.enums.PaymentMode;
import com.interview.interview1.model.User;

public class Application {

    // Phone pe machine coding round
    public static void main(String[] args) {
        OnlineShoppingCompany onlineShoppingCompany = OnlineShoppingCompany.getInstance();
        onlineShoppingCompany.createUser(new User("1", "Harsh", "harsh@email", "pass1", 2000));
        onlineShoppingCompany.createUser(new User("2", "Naman", "naman@email", "pass2", 4000));
        onlineShoppingCompany.createUser(new User("3", "Manish", "Manish@email", "pass3", 1000));

        onlineShoppingCompany.addToCart("1", 23, 1);

        onlineShoppingCompany.checkout("1", "abc", PaymentMode.UPI);
    }

}
