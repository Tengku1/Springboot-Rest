package com.northwind.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.northwind.api.dto.OrderDetailDto;
import com.northwind.api.dto.OrderDto;
import com.northwind.api.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders", schema = "dbo")
public class Order {
    @Id
    @Column(name = "orderid",updatable = false, nullable = false)
    private int orderId;

    @Column(name = "employeeid")
    private int employeeId;

    @Column(name = "orderdate")
    private LocalDateTime orderDate;

    @Column(name = "requireddate")
    private LocalDateTime requiredDate;

    @Column(name = "shippeddate")
    private LocalDateTime shippedDate;

    @Column(name = "shipvia")
    private int shipVia;

    @Column(name = "freight")
    private Long freight;

    @Column(name = "shipname")
    private String shipName;

    @Column(name = "shipaddress")
    private String shipAddress;

    @Column(name = "shipcity")
    private String shipCity;

    @Column(name = "shipregion")
    private String shipRegion;

    @Column(name = "shippostalcode")
    private String shipPostalCode;

    @Column(name = "shipcountry")
    private String shipCountry;

    @ManyToMany
    @JoinTable(
            name = "\"Order Details\"", schema = "dbo",
            joinColumns = @JoinColumn(name = "orderid"),
            inverseJoinColumns = @JoinColumn(name = "productid"))
    private List<Products> products;

    public OrderDto convertToDto() {
        List<ProductDto> productDtos = products.stream().map(product -> product.convertToDto(orderId)).toList();
        OrderDto orderDto = OrderDto.builder()
                .orderId(orderId)
                .productDto(productDtos)
                .build();
        return orderDto;
    }
}
