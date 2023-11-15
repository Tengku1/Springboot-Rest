package com.northwind.api.services.impl;

import com.northwind.api.entities.Order;
import com.northwind.api.repositories.OrderRepository;
import com.northwind.api.services.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    @Override
    public List<Order> findAllOrders() {
        return repository.findAll();
    }
}
