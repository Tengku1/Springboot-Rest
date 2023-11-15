package com.northwind.api.repositories;

import com.northwind.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "orders")
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
