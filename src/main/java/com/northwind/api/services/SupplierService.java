package com.northwind.api.services;

import com.northwind.api.entities.Suppliers;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService extends BaseService {
    List<Suppliers> findAllSuppliers();

    Page<Suppliers> findAllSuppliers(int page, int limit, String sort);
    Page<Suppliers> findAllSuppliersByCity(String city, int page, int limit, String sort);
}
