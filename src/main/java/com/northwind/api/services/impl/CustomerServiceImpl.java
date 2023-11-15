package com.northwind.api.services.impl;

import com.northwind.api.entities.Customer;
import com.northwind.api.repositories.CustomerRepository;
import com.northwind.api.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @Override
    public int updateCustomers(String id, String companyName, String categoryName, String title, String address, String city, String region, String postalCode, String country, String phone, String fax) {
        return repository.updateCustomers(id,companyName,categoryName,title,address,city,region,postalCode,country,phone,fax);
    }

    @Override
    public List<Customer> findCustomerByCountry(String country) {
        return repository.findCustomerByCountry(country);
    }
}
