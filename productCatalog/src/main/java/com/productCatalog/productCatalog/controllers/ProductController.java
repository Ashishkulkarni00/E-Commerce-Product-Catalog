package com.productCatalog.productCatalog.controllers;

import com.productCatalog.productCatalog.entities.Product;
import com.productCatalog.productCatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;
    //method to add a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
       return productService.createProduct(product);
    }

    //method to update a product
    @PutMapping("/{product_id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable("product_id") int productId) {
        return productService.updateProductById(product,productId);
    }

    //method to remove a product
    @DeleteMapping("/{product_id}")
    public String deleteProduct(@PathVariable("product_id") int productId) {
        productService.deleteProductById(productId);
        return "Product successfully deleted";
    }

    //list products under a category
    @GetMapping("/category/{category-id}")
    public List<Product> getAllProductsByCategoryId(@PathVariable("category-id") int categoryId)  {
        return productService.getProductByCategoryId(categoryId);
    }

    //method to get product by product id
    @GetMapping("/{product_id}")
    public Product getProductById(@PathVariable("product_id") int productId)  {
        return productService.getProductByProductId(productId);
    }

    //method to get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
