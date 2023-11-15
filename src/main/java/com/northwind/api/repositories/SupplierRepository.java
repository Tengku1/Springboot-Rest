package com.northwind.api.repositories;

import com.northwind.api.entities.Suppliers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
@RepositoryRestResource(path="suppliers")
public interface SupplierRepository extends JpaRepository<Suppliers, Long> {
    public Page<Suppliers> findByCityContainingIgnoreCase(String param, Pageable pageable);
}
