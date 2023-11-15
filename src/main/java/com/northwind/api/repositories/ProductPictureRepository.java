package com.northwind.api.repositories;

import com.northwind.api.entities.ProductPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPictureRepository extends JpaRepository<ProductPicture, Long> {
}
