package com.northwind.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDto {
    private Long categoryId;

    @Size(max = 55, message = "category name length exceeded")
    @NotBlank(message = "categoryname can't be null")
    private String categoryName;

    private String description;
}