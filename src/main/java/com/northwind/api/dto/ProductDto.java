package com.northwind.api.dto;

import com.northwind.api.entities.OrderDetail;
import com.northwind.api.entities.ProductPicture;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ProductDto {
    private Long productId;

    @NotBlank(message = "Product Name Cannot Be Null !")
    private String productName;

    @NotBlank(message = "Product Name Cannot Be Null !")
    private Long supplierId;

    @NotBlank(message = "Product Name Cannot Be Null !")
    private Long categoryId;

    private String quantityPerUnit;
    private Double unitPrice;
    private Double unitsInStock;
    private Double unitsOnOrder;
    private Double reorderLevel;

    @NotBlank(message = "Discontinued Cannot Be Null !")
    private Boolean discontinued;

    private OrderDetail orderDetail;
}
