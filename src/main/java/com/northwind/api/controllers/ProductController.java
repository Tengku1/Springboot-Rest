package com.northwind.api.controllers;

import com.northwind.api.entities.Products;
import com.northwind.api.mapper.ProductMapper;
import com.northwind.api.services.FileService;
import com.northwind.api.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor()
@Slf4j
public class ProductController {
    private final ProductService service;
    private final FileService fileService;
    private ProductMapper mapper;

    @GetMapping
    public ResponseEntity<?> findAllProducts() {
        log.debug("Products :: Get All Products");
        List<Products> products = service.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(
            @RequestParam("productName") String productName,
            @RequestParam("supplierId") Long supplierId,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("unitPrice") Double unitPrice,
            @RequestParam(value = "unitsInStock", required = false) Double unitsInStock,
            @RequestParam(value = "unitsOnOrder", required = false) Double unitsOnOrder,
            @RequestParam(value = "reorderLevel", required = false) Double reorderLevel,
            @RequestParam(value = "discontinued", required = false) Boolean discontinued,
            @RequestParam(value = "images", required = false) List<MultipartFile> files
    ) throws IOException {
        Products products = new Products();
        products.setProductName(productName);
        products.setSupplierId(supplierId);
        products.setCategoryId(categoryId);
        products.setUnitPrice(unitPrice);

        if(files != null) {
            fileService.storeFiles(files);
        }

        return ResponseEntity.ok(service.createProduct(products, files));
    }

    @PutMapping
    public ResponseEntity<String> editProduct(@RequestParam Long id ,@RequestParam MultipartFile files) {
        Products products = service.findProductById(id);
        return new ResponseEntity<>(files.getContentType(), HttpStatus.OK);
    }
}
