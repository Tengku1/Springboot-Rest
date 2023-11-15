package com.northwind.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "productpictures", schema = "dbo")
public class ProductPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pictid", updatable = false, nullable = false)
    private Long pictId;

    @Column(name = "productid")
    private Long productid;

    @Column(name = "pictfilename")
    private String pictFileName;

    @Column(name = "pictsize")
    private int pictSize;

    @Column(name = "pictfiletype")
    private String pictFileType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    private Products products;
}
