package com.northwind.api.services.impl;

import com.northwind.api.entities.Suppliers;
import com.northwind.api.repositories.SupplierRepository;
import com.northwind.api.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository repository;
    @Override
    public <T> Optional<T> createEntity(T entity) {
        return Optional.empty();
    }

    @Override
    public <T> List<T> findAllEntity() {
        return null;
    }

    @Override
    public <T> T findEntityById(Long id) {
        return null;
    }

    @Override
    public void deleteEntityById(Long id) {

    }
    @Override
    public List<Suppliers> findAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public Page<Suppliers> findAllSuppliers(int page, int limit, String sort) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sort));
        return repository.findAll(pageable);
    }

    @Override
    public Page<Suppliers> findAllSuppliersByCity(String city, int page, int limit, String sort) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sort));
        return repository.findByCityContainingIgnoreCase(city,pageable);
    }
}
