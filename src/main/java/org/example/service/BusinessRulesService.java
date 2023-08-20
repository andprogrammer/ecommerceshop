package org.example.service;

import org.example.model.Order;
import org.example.model.Product;

public class BusinessRulesService {
    private int bulkBuyLimit;
    private int bulkBuyLimitCategory;

    public BusinessRulesService(int bulkBuyLimit, int bulkBuyLimitCategory) {
        this.bulkBuyLimit = bulkBuyLimit;
        this.bulkBuyLimitCategory = bulkBuyLimitCategory;
    }

    public boolean isRestrictionBreached(Order order) {
        for (Product product : order.getProducts().keySet()) {
            if (isRestrictionBreached(product, order.getProducts().get(product))) {
                return true;
            }
        }
        return false;
    }

    public boolean isRestrictionBreached(Product product, int quantity) {
        if (product.getCategory().equalsIgnoreCase("Paracetamol") && quantity > bulkBuyLimitCategory) {
            return true; // Category quantity restriction breached
        }
        if (quantity > bulkBuyLimit) {
            return true; // Quantity restriction breached
        }
        return false; // No restriction breached
    }
}
