package com.productCatalog.productCatalog.controllers;

import com.productCatalog.productCatalog.entities.Category;
import com.productCatalog.productCatalog.repositories.CategoryRepository;
import com.productCatalog.productCatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    //method to add a new category
    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    //method to update a category
    @PutMapping("/{category_id}")
    public Category updateCatgeory(@RequestBody Category category, @PathVariable("category_id") int categoryId) {
        return categoryService.updateCategory(category,categoryId);
    }

    //method to delete a category
    @DeleteMapping("/{category-id}")
    public String deleteCategory(@PathVariable("category-id") int categoryId) {
         categoryService.deleteCategory(categoryId);
         return "Category Successfully Deleted";
    }

    //method to get catgeory by category id
    @GetMapping("/{category-id}")
    public Category getCategoryById(@PathVariable("category-id") int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }


    //method to get all categories
    @GetMapping
    public List<Category> getAllCategories(){
    return categoryService.getAllCategories();
    }
}
