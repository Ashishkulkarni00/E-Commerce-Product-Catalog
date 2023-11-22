package com.productCatalog.productCatalog.services;

import com.productCatalog.productCatalog.exception.ProductException;
import com.productCatalog.productCatalog.entities.Category;
import com.productCatalog.productCatalog.entities.Product;
import com.productCatalog.productCatalog.repositories.CategoryRepository;
import com.productCatalog.productCatalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category, int categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ProductException("Invalid Category id"));

        // Update values if they are not null
        if (category.getCategory_name() != null) {
            existingCategory.setCategory_name(category.getCategory_name());
        }

        if (category.getCategory_description() != null) {
            existingCategory.setCategory_description(category.getCategory_description());
        }

        // Save the updated entity
        return categoryRepository.save(existingCategory);
    }



    public void deleteCategory(int categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            List<Product> products = productRepository.findProductsByCategoryId(categoryId);
            for (Product product : products) {
                productRepository.deleteById(product.getProduct_id());
            }
            categoryRepository.deleteById(categoryId);
        } else {
            throw new ProductException("Invalid Category id");
        }
    }

    public Category getCategoryById(int categoryId) {
        if(categoryRepository.existsById(categoryId)){
            return categoryRepository.findById(categoryId).get();
        }else{
            throw new ProductException("Invalid Category id");
        }
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
