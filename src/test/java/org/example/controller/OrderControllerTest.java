package org.example.controller;

import org.example.model.Order;
import org.example.model.Product;
import org.example.service.BusinessRulesService;
import org.example.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    private OrderService orderService;

//    @Mock
//    private BusinessRulesService businessRulesService;

    @BeforeEach
    void setUp() {
        BusinessRulesService businessRulesService = new BusinessRulesService(2, 4);
        orderService = new OrderService(businessRulesService);
    }

    @Test
    void testRestrictionMet() {
        // ToDo need improvements
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product(8L, "Paracetamol"), 1);
        Order order = new Order(products);
//        when(businessRulesService.isRestrictionBreached(any())).thenReturn(false);
        assertEquals(orderService.addNewOrder(order), OrderService.MET);
        assertEquals(orderService.getNumberOfOrders(), 1);
    }

    @Test
    void testRestrictionBreached() {
        // ToDo need improvements
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product(16L, "Paracetamol"), 8);
        Order order = new Order(products);
//        when(businessRulesService.isRestrictionBreached(any())).thenReturn(true);
        assertEquals(orderService.addNewOrder(order), "BREACHED");
        assertEquals(orderService.getNumberOfOrders(), 0);
    }
}
