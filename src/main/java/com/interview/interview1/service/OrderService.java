package com.interview.interview1.service;

import com.interview.interview1.enums.OrderStatus;
import com.interview.interview1.enums.PaymentMode;
import com.interview.interview1.enums.PaymentStatus;
import com.interview.interview1.model.Cart;
import com.interview.interview1.model.CartItem;
import com.interview.interview1.model.Order;
import com.interview.interview1.model.User;
import com.interview.interview1.respository.CartRepository;
import com.interview.interview1.respository.OrderRepository;
import com.interview.interview1.respository.UserDetailsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderService {

    private OrderRepository orderRepository;

    private UserDetailsRepository userDetailsRepository;

    private CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, UserDetailsRepository userDetailsRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.cartRepository = cartRepository;
    }

    public List<Order> getOrderHistory(String userId) throws Exception {
        User user = userDetailsRepository.getUserRepoMap().get(userId);
        if (Objects.isNull(user)) {
            throw new Exception("User not found");
        }

        List<Order> orders = orderRepository.getOrderRepoMap().get(userId);
        return orders;
    }

    public Order checkout(String userId, String shippingAddress, PaymentMode paymentMode) throws Exception {
        User user = userDetailsRepository.getUserRepoMap().get(userId);
        if (Objects.isNull(user)) {
            throw new Exception("User not found");
        }

        Cart cart = cartRepository.getcartRepoMap().get(userId);
        if (cart.getCartItemMap().isEmpty()) {
            throw new Exception("User cart is empty");
        }

        List<CartItem> cartItems = new ArrayList<>();
        final int[] cartTotalAmt = {0};
        cart.getCartItemMap().forEach((productId, cartItem) -> {
            cartItems.add(cartItem);
            cartTotalAmt[0] += cartItem.getProduct().getPrice() * cartItem.getQty();
        });

        Order order = new Order();
        order.setOrderItems(cartItems);
        order.setShippingAddress(shippingAddress);
        order.setAmount(cartTotalAmt[0]);
        order.setOrderStatus(OrderStatus.YET_TO_DISPATCH);
        order.setPaymentMode(PaymentMode.UPI);

        if (paymentMode == PaymentMode.CASH_ON_DELIVERY) {
            order.setPaymentStatus(PaymentStatus.NONE);
        } else {
            order.setPaymentStatus(PaymentStatus.SUCCESS);
            user.reduceBalance(cartTotalAmt[0]);
        }

        cartRepository.makeCartEmpty(userId);

        return order;
    }
}
