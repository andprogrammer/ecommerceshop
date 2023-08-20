package org.example.service;

import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public static final String BREACHED = "BREACHED";
    public static final String MET = "MET";
    private List<Order> orders;
    private BusinessRulesService businessRulesService;

    public OrderService(BusinessRulesService businessRulesService) {
        this.businessRulesService = businessRulesService;
        orders = new ArrayList<>();
    }

    public String addNewOrder(Order order) {
        if (businessRulesService.isRestrictionBreached(order)) {
            return BREACHED;
        }
        orders.add(order);
        return MET;
    }

    public int getNumberOfOrders() {
        return orders.size();
    }
}
