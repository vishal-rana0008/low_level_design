package com.interview.service;

import com.interview.model.Cart;
import com.interview.model.CartItem;
import com.interview.model.Product;
import com.interview.model.User;
import com.interview.respository.CartRepository;
import com.interview.respository.ProductRepository;
import com.interview.respository.UserDetailsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductAndCartService {

    private ProductRepository productRepository;

    private UserDetailsRepository userDetailsRepository;

    private CartRepository cartRepository;

    public ProductAndCartService(ProductRepository productRepository, UserDetailsRepository userDetailsRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.cartRepository = cartRepository;
    }

    public Product getProduct(int productId) throws Exception {
        Product product = productRepository.getProductRepoMap().get(productId);
        if (Objects.isNull(product)) {
            throw new Exception("Invalid query product");
        }
        return product;
    }

    public void addToCart(String userId, int productId, int qty) throws Exception {
        User user = userDetailsRepository.getUserRepoMap().get(userId);
        if (Objects.isNull(user)) {
            throw new Exception("User not found");
        }

        Product product = productRepository.getProductRepoMap().get(productId);
        if (Objects.isNull(product)) {
            throw new Exception("Invalid query product");
        }

        CartItem cartItem = new CartItem(product, qty);
        cartRepository.addItemInCart(cartItem, user.getUserId());
    }

    public List<CartItem> getCart(String userId) throws Exception {
        User user = userDetailsRepository.getUserRepoMap().get(userId);
        if (Objects.isNull(user)) {
            throw new Exception("User not found");
        }

        Cart cart = cartRepository.getcartRepoMap().get(userId);
        List<CartItem> cartItems = new ArrayList<>();
        cart.getCartItemMap().forEach((productId, cartItem) -> cartItems.add(cartItem));

        return cartItems;
    }
}
