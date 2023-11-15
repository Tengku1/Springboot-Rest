package com.northwind.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductPictureDto {
    private Long pictId;

    @NotBlank(message = "Product ID Cannot Be Null !")
    private Long productid;

    @NotBlank(message = "File Name Cannot Be Null !")
    private String pictFileName;

    @NotBlank(message = "File Size Cannot Be Null !")
    private int pictSize;

    @NotBlank(message = "File Type Cannot Be Null !")
    private String pictFileType;
}
