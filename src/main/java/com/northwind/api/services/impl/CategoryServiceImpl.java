package com.northwind.api.services.impl;

import com.northwind.api.entities.Category;
import com.northwind.api.repositories.CategoryRepository;
import com.northwind.api.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    @Override
    public List<Category> findAllCategory() {
        return repository.findAll();
    }

    @Override
    public int updateContactCategory(String categoryName, Long id) {
        return repository.updateCategoryContact(categoryName,id);
    }

    @Override
    public <T> Optional<T> createEntity(T entity) {
        Category category = (Category) entity;
        repository.save(category);
        return (Optional<T>) Optional.of(category);
    }

    @Override
    public <T> List<T> findAllEntity() {
        return null;
    }

    @Override
    public <T> T findEntityById(Long id) {
        return null;
    }

    @Override
    public void deleteEntityById(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }
}