package com.northwind.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.northwind.api.dto.OrderDetailDto;
import com.northwind.api.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products", schema = "dbo")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid", updatable = false, nullable = false)
    private Long productId;

    @Column(name = "productname")
    private String productName;

    @Column(name = "supplierid")
    private Long supplierId;

    @Column(name = "categoryid")
    private Long categoryId;

    @Column(name = "quantityperunit")
    private String quantityPerUnit;

    @Column(name = "unitprice")
    private Double unitPrice;

    @Column(name = "unitsinstock")
    private Double unitsInStock;

    @Column(name = "unitsonorder")
    private Double unitsOnOrder;

    @Column(name = "reorderlevel")
    private Double reorderLevel;

    @Column(name = "discontinued")
    private Boolean discontinued = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "supplierid", insertable = false, updatable = false)
    private Suppliers suppliers;

    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductPicture> productPictures;

    public ProductDto convertToDto(int orderId){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(productId);
        productDto.setUnitPrice(unitPrice);
        productDto.setProductName(productName);
        for (OrderDetail orderDetail: orderDetails) {
            if(orderDetail.getOrderId() == orderId) {
                productDto.setOrderDetail(orderDetail);
            }
        }
        return productDto;
    }
}
