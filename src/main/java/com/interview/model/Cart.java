package com.interview.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Cart {
    int cartId;

    // productId, cartItem
    Map<Integer, CartItem> cartItemMap;

    public Cart() {
        cartId = ThreadLocalRandom.current().nextInt();
        this.cartItemMap = new HashMap<>();
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public void insetCartItem(CartItem cartItem) {
        cartItemMap.put(cartItem.getProduct().getProductId(), cartItem);
    }
}
