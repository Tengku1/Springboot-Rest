package com.northwind.api.controllers;

import com.northwind.api.dto.OrderDto;
import com.northwind.api.entities.Order;
import com.northwind.api.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository repository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<OrderDto> orderDtoList = repository.findAll().stream().map(Order::convertToDto).toList();
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable("id") int id) {
        OrderDto orderDto = repository.findById(id).orElseThrow().convertToDto();
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }
}
