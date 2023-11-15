package com.northwind.api.mapper;

import com.northwind.api.dto.ProductDto;
import com.northwind.api.entities.Products;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Products map(ProductDto productDto);
    ProductDto map(Products products);

    List<ProductDto> map(List<Products> products);
}
