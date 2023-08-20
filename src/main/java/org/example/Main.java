package org.example;

import org.example.controller.OrderController;
import org.example.model.Order;
import org.example.model.Product;
import org.example.service.BusinessRulesService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void run() {
        System.out.printf("Welcome to the Order Service\n");
        BusinessRulesService businessRulesService = new BusinessRulesService(10, 5);
        OrderController controller = new OrderController(businessRulesService);
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product(8L, "Paracetamol"), 1);
        Order order = new Order(products);

        controller.addNewOrder(order);
        System.out.println("Number of orders=" + controller.getNumberOfOrders());
    }

    public static void main(String[] args) {
        run();
    }
}

/*

E-commerce shop gets millions of orders every day with an average basket size of 100 items.
E-commerce shop Business has got some regulations around selling products online and in stores.
These regulations are mandatory from legal and business perspective to enforce for all order transactions.

You are given an order with a list of products in the shopping cart/basket
with productid, product Category and quantity. And also, Restriction Rules on Qty and Qty/Category.



Example:

Ordered items in the shopping cart/basket

Item-1 -> productid=1, category=Paracetamol, quantity=3

Item-2 -> productid=2, category=analgesic, quantity=3

Item-3 -> productid=3, category=chocolate, quantity=8

Item-4 -> productid=4, category= Paracetamol, quantity=2



Business Restriction rules:

Cannot buy more than 10 Quantity of any products - BulkBuyLimit

Cannot buy more than 5 Quantity of paracetamol products – BulkBuyLimitCategory



Write a restriction rule engine to run the restriction check against the shopping cart/basket and return the status
as MET/BREACHED indicating restriction status for the given restriction rules.

For the above given example, the restriction status returned would be MET.
 */