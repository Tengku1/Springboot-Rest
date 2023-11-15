package com.northwind.api.controllers;

import com.northwind.api.dto.CategoryDto;
import com.northwind.api.dto.CustomerDto;
import com.northwind.api.entities.Customer;
import com.northwind.api.exception.EntityNotFoundException;
import com.northwind.api.mapper.CustomerMapper;
import com.northwind.api.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService service;
    private final CustomerMapper mapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        logger.debug("Resources:: request to get all customers");
        // mapping
        List<CustomerDto> customers = mapper.map(service.findAllCustomers());
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findCustomerByCountry(@QueryParam("country") String country) {
        logger.debug("Resources:: request to get all categories");
        // mapping
        List<CustomerDto> customers = mapper.map(service.findCustomerByCountry(country));
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerDto req) {
        logger.debug("Resources:: request to get all categories");
        // mapping
        int status = service.updateCustomers(req.getCustomerId(), req.getCompanyName(),req.getContactName(), req.getContactTitle(), req.getAddress(), req.getCity(), req.getRegion(), req.getPostalCode(), req.getCountry(), req.getPhone(), req.getFax());
        if(status != 1) {
            throw new EntityNotFoundException("Customer ID : " + req.getCustomerId() + " Not Found !");
        }

        return new ResponseEntity<>(req, HttpStatus.OK);
    }
}
