package com.northwind.api.repositories;

import com.northwind.api.entities.Order;
import com.northwind.api.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "order details")
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Order> {
}
