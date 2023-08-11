package com.interview;

import com.interview.enums.PaymentMode;
import com.interview.model.*;
import com.interview.respository.CartRepository;
import com.interview.respository.OrderRepository;
import com.interview.respository.ProductRepository;
import com.interview.respository.UserDetailsRepository;
import com.interview.service.OrderService;
import com.interview.service.ProductAndCartService;
import com.interview.service.UserService;

import java.util.List;

public class OnlineShoppingCompany {
    private static OnlineShoppingCompany onlineShoppingCompany;

    private OrderService orderService;

    private ProductAndCartService productAndCartService;

    private UserService userService;

    private OnlineShoppingCompany() {
        CartRepository cartRepository = new CartRepository();
        OrderRepository orderRepository = new OrderRepository();
        ProductRepository productRepository = new ProductRepository();
        UserDetailsRepository userDetailsRepository = new UserDetailsRepository();

        this.orderService = new OrderService(orderRepository, userDetailsRepository, cartRepository);
        this.productAndCartService = new ProductAndCartService(productRepository, userDetailsRepository, cartRepository);
        this.userService = new UserService(userDetailsRepository, cartRepository);
    }

    public synchronized static OnlineShoppingCompany getInstance() {
        if (onlineShoppingCompany == null) {
            onlineShoppingCompany = new OnlineShoppingCompany();
        }
        return onlineShoppingCompany;
    }

    public void createUser(User user) {
        try {
            userService.createUser(user);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public User getUser(String userId) {
        try {
            return userService.getUser(userId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Product getProduct(int productId) {
        try {
            return productAndCartService.getProduct(productId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void addToCart(String userId, int productId, int qty) {
        try {
            productAndCartService.addToCart(userId, productId, qty);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<CartItem> getCart(String userId) {
        try {
            return productAndCartService.getCart(userId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Order> getOrderHistory(String userId) {
        try {
            return orderService.getOrderHistory(userId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Order checkout(String userId, String shippingAddress, PaymentMode paymentMode) {
        try {
            return orderService.checkout(userId, shippingAddress, paymentMode);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
