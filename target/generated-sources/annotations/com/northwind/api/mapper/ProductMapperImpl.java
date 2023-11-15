package com.northwind.api.mapper;

import com.northwind.api.dto.ProductDto;
import com.northwind.api.entities.Products;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-16T05:42:34+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Products map(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Products products = new Products();

        products.setProductId( productDto.getProductId() );
        products.setProductName( productDto.getProductName() );
        products.setSupplierId( productDto.getSupplierId() );
        products.setCategoryId( productDto.getCategoryId() );
        products.setQuantityPerUnit( productDto.getQuantityPerUnit() );
        products.setUnitPrice( productDto.getUnitPrice() );
        products.setUnitsInStock( productDto.getUnitsInStock() );
        products.setUnitsOnOrder( productDto.getUnitsOnOrder() );
        products.setReorderLevel( productDto.getReorderLevel() );
        products.setDiscontinued( productDto.getDiscontinued() );

        return products;
    }

    @Override
    public ProductDto map(Products products) {
        if ( products == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( products.getProductId() );
        productDto.setProductName( products.getProductName() );
        productDto.setSupplierId( products.getSupplierId() );
        productDto.setCategoryId( products.getCategoryId() );
        productDto.setQuantityPerUnit( products.getQuantityPerUnit() );
        productDto.setUnitPrice( products.getUnitPrice() );
        productDto.setUnitsInStock( products.getUnitsInStock() );
        productDto.setUnitsOnOrder( products.getUnitsOnOrder() );
        productDto.setReorderLevel( products.getReorderLevel() );
        productDto.setDiscontinued( products.getDiscontinued() );

        return productDto;
    }

    @Override
    public List<ProductDto> map(List<Products> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Products products1 : products ) {
            list.add( map( products1 ) );
        }

        return list;
    }
}
