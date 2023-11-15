package com.northwind.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name =  "\"order details\"", schema = "dbo")
public class OrderDetail {
    @Id
    @Column(name = "orderid")
    private int orderId;

    @Column(name = "productid")
    private int productId;

    @Column(name = "unitprice")
    private double unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private float discount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    private Products products;
}
