package com.interview.respository;

import com.interview.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    // userId, list of orders
    Map<String, List<Order>> orderRepoMap;

    public OrderRepository() {
        this.orderRepoMap = new HashMap<>();
    }

    public Map<String, List<Order>> getOrderRepoMap() {
        return orderRepoMap;
    }
}
