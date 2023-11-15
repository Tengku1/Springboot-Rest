package com.northwind.api.dto;

import lombok.Data;

@Data
public class PaginationDto {
    private int page;
    private int limit;
    private String sort;
}
