package com.interview.interview1.respository;

import com.interview.interview1.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    // productId, Product
    Map<Integer, Product> productRepoMap;

    public ProductRepository() {
        this.productRepoMap = new HashMap<>();
        productRepoMap.put(23, new Product(23, "Table", "furniture", 400.0));
        productRepoMap.put(24, new Product(24, "Fan", "Electricity", 300.0));
        productRepoMap.put(25, new Product(25, "AC stabilizer", "Electricity", 1000.0));
    }

    public Map<Integer, Product> getProductRepoMap() {
        return productRepoMap;
    }

    public void addProduct(Integer productId, Product product) {
        productRepoMap.put(productId, product);
    }
}
