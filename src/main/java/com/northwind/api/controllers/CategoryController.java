package com.northwind.api.controllers;

import com.northwind.api.dto.CategoryDto;
import com.northwind.api.entities.Category;
import com.northwind.api.exception.EntityNotFoundException;
import com.northwind.api.mapper.CategoryMapper;
import com.northwind.api.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService service;
    private final CategoryMapper mapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        logger.debug("Resources:: request to get all categories");
        // mapping
        List<CategoryDto> categoryDto = mapper.map(service.findAllCategory());
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto req) {
        logger.debug("Resources:: request to create categories");
        Category entity = mapper.map(req);

        entity = service.createEntity(entity).orElseThrow(() -> new RuntimeException("Failed to create category"));
        CategoryDto resDto = mapper.map(entity);
        return new ResponseEntity<>(resDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCategoryContact(@Valid @RequestBody CategoryDto req) {
        logger.debug("Resources:: request to update category contact");

        int status = service.updateContactCategory(req.getCategoryName(), req.getCategoryId());
        if(status == 0) {
            throw new EntityNotFoundException("Category ID Not Found !");
        }

        return new ResponseEntity<>(req, HttpStatus.CREATED);
    }

//    @DeleteMapping
//    public ResponseEntity<?> destroyCategory(@Valid @RequestBody CategoryDto req) {
//        logger.debug("Resources:: request to destroy category");
//
//        service.deleteEntityById(req.getCategoryId());
//
//        return new ResponseEntity<>("Category ID: " + req.getCategoryId() + " Telah Dihapus", HttpStatus.CREATED);
//    }
}
