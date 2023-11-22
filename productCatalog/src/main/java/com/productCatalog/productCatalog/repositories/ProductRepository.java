package com.productCatalog.productCatalog.repositories;

import com.productCatalog.productCatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE p.category.category_id = :categoryId")
    List<Product> findProductsByCategoryId(int categoryId);
}
