package com.northwind.api.mapper;

import com.northwind.api.dto.CategoryDto;
import com.northwind.api.entities.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface CategoryMapper {
//    entity to dto
    CategoryDto map(Category category);

//    dto to entity
    Category map(CategoryDto categoryDto);
    List<CategoryDto> map(List<Category> categories);
}
