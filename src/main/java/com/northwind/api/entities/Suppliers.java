package com.northwind.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "suppliers", schema = "dbo")
public class Suppliers {
    @Id
    @Column(name="supplierid",updatable = false, nullable = false)
    private Long supplierId;

    @Column(name="companyname")
    private String companyName;

    @Column(name="city")
    private String city;

    @OneToMany(mappedBy = "suppliers", fetch = FetchType.LAZY)
    private List<Products> products;
}
