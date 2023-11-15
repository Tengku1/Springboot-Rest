package com.northwind.api.services;

import com.northwind.api.entities.Category;

import java.util.List;

public interface CategoryService extends BaseService {
    List<Category> findAllCategory();
    int updateContactCategory(String categoryName, Long id);
}
