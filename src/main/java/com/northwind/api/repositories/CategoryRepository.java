package com.northwind.api.repositories;

import com.northwind.api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update dbo.categories set categoryname=:categoryName where categoryid=:categoryId",nativeQuery = true)
    int updateCategoryContact(String categoryName, Long categoryId);
}
