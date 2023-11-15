package com.northwind.api.dto;

import lombok.Data;

@Data
public class OrderDetailDto {
    private Long orderId;

    private Long productId;

    private Double unitPrice;

    private int quantity;

    private float discount;
}
