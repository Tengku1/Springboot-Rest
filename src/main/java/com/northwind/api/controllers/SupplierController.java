package com.northwind.api.controllers;

import com.northwind.api.entities.Suppliers;
import com.northwind.api.services.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
@Slf4j
public class SupplierController {
    private final SupplierService service;

    @GetMapping
    public ResponseEntity<?> findAllSuppliers(
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "page", required = false) int page,
            @RequestParam(name = "limit", required = false) int limit
    ) {
        return new ResponseEntity<>(service.findAllSuppliers(page,limit,sort), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findAllSupplierByCity(
            @RequestParam(name = "city", required = true) String city,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "page", required = false) int page,
            @RequestParam(name = "limit", required = false) int limit
    ) {
        return new ResponseEntity<>(service.findAllSuppliersByCity(city,page,limit,sort), HttpStatus.OK);
    }
}
