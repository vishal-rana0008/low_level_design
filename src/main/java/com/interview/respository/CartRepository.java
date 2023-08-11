package com.interview.respository;

import com.interview.model.Cart;
import com.interview.model.CartItem;

import java.util.Map;

public class CartRepository {
    // userId, Cart
    private Map<String, Cart> cartRepoMap;

    public Map<String, Cart> getcartRepoMap() {
        return cartRepoMap;
    }

    public void makeCartEmpty(String userId) {
        cartRepoMap.put(userId, new Cart());
    }

    public void addItemInCart(CartItem cartItem, String userId) {
        Cart cart = cartRepoMap.get(userId);
        cart.insetCartItem(cartItem);
    }
}
