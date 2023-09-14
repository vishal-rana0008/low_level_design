package com.interview.interview1.model;

import com.interview.interview1.enums.OrderStatus;
import com.interview.interview1.enums.PaymentMode;
import com.interview.interview1.enums.PaymentStatus;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Order {
    int orderId;
    String shippingAddress;
    OrderStatus orderStatus;
    double amount;
    PaymentMode paymentMode;
    PaymentStatus paymentStatus;
    List<CartItem> orderItems;

    public Order() {
        this.orderId = ThreadLocalRandom.current().nextInt();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<CartItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<CartItem> orderItems) {
        this.orderItems = orderItems;
    }
}
