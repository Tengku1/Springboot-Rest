package com.northwind.api.services;

import com.northwind.api.entities.Products;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService{
    List<Products> findAllProducts();
    Products findProductById(Long id);
    Products createProduct(Products products, List<MultipartFile> image);
}
