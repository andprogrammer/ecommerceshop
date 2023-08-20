package org.example.model;

import java.util.Map;

public class Order {
    private Map<Product, Integer> products;

    public Order(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
