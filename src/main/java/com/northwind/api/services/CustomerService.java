package com.northwind.api.services;

import com.northwind.api.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    public List<Customer> findCustomerByCountry(String country);
    int updateCustomers(String id, String companyName, String customerName, String title, String address, String city, String region, String postalCode, String country, String phone, String fax);
}
