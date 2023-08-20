package org.example.controller;

import org.example.model.Order;
import org.example.service.BusinessRulesService;
import org.example.service.OrderService;

public class OrderController {

    private OrderService orderService;

    public OrderController(BusinessRulesService businessRulesService) {
        this.orderService = new OrderService(businessRulesService);
    }

    public String addNewOrder(Order order) {
        return orderService.addNewOrder(order);
    }

    public int getNumberOfOrders() {
        return orderService.getNumberOfOrders();
    }
}
