package com.interview;

import com.interview.enums.PaymentMode;
import com.interview.model.User;

public class Application {
    public static void main(String[] args) {
        OnlineShoppingCompany onlineShoppingCompany = OnlineShoppingCompany.getInstance();
        onlineShoppingCompany.createUser(new User("1", "Harsh", "harsh@email", "pass1", 2000));
        onlineShoppingCompany.createUser(new User("2", "Naman", "naman@email", "pass2", 4000));
        onlineShoppingCompany.createUser(new User("3", "Manish", "Manish@email", "pass3", 1000));

        onlineShoppingCompany.addToCart("1", 23, 1);

        onlineShoppingCompany.checkout("1", "abc", PaymentMode.UPI);
    }

}
