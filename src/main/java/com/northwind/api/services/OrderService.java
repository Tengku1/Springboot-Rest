package com.northwind.api.services;

import com.northwind.api.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
}
