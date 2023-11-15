package com.northwind.api.mapper;

import com.northwind.api.dto.CategoryDto;
import com.northwind.api.dto.CustomerDto;
import com.northwind.api.entities.Category;
import com.northwind.api.entities.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    CustomerDto map(Category category);
    Customer map(CategoryDto categoryDto);
    List<CustomerDto> map(List<Customer> customers);
}
