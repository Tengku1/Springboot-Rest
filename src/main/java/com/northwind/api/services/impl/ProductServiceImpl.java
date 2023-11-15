package com.northwind.api.services.impl;

import com.northwind.api.entities.ProductPicture;
import com.northwind.api.entities.Products;
import com.northwind.api.exception.EntityNotFoundException;
import com.northwind.api.repositories.ProductPictureRepository;
import com.northwind.api.repositories.ProductRepository;
import com.northwind.api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductPictureRepository productPictureRepository;

    @Override
    public List<Products> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public Products findProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product ID : " + id + " Not Found !"));
    }

    @Override
    public Products createProduct(Products products, List<MultipartFile> images) {
        products = repository.save(products);
        if(images != null) {
            System.out.println("TEST");
            for (MultipartFile image: images) {
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

                ProductPicture productPicture = new ProductPicture();
                productPicture.setProductid(products.getProductId());
                productPicture.setPictFileName(fileName);
                productPicture.setPictSize((int) image.getSize());
                productPicture.setPictFileType(image.getContentType());
                productPicture.setProducts(products);

                productPictureRepository.save(productPicture);
            }
        }
        return products;
    }
}
