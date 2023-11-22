package com.productCatalog.productCatalog.services;

import com.productCatalog.productCatalog.exception.ProductException;
import com.productCatalog.productCatalog.entities.Category;
import com.productCatalog.productCatalog.entities.Product;
import com.productCatalog.productCatalog.repositories.CategoryRepository;
import com.productCatalog.productCatalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    //create product
    public Product createProduct(Product product) {
        Category productCategory = product.getCategory();

        if (productCategory == null || productCategory.getCategory_id() <= 0) {
            throw new ProductException("Specify a valid Category for this product");
        }

        if (categoryRepository.existsById(productCategory.getCategory_id())) {
            return productRepository.save(product);
        } else {
            throw new ProductException("Invalid Category Id");
        }
    }


    //get products by category id
    public List<Product> getProductByCategoryId(int categoryId) {
        if(categoryRepository.existsById(categoryId)){
            List<Product> output=new ArrayList<>();
            List<Product> temp=productRepository.findAll();
            for(Product product:temp){
                if(product.getCategory().getCategory_id()==categoryId){
                    output.add(product);
                }
            }
            return output;
        }else{
            throw new ProductException("No product found for this category / Invalid Category Id");
        }
    }
    //update product
    public Product updateProductById(Product product,int productId)  {
        if(productRepository.existsById(productId)){
            Product existingProduct=productRepository.findById(productId).get();
            existingProduct.setProduct_description(product.getProduct_description());
            existingProduct.setProduct_name(product.getProduct_name());
            existingProduct.setProduct_price(product.getProduct_price());
            if(categoryRepository.existsById(product.getCategory().getCategory_id())){
                existingProduct.setCategory(product.getCategory());
            }
            else{
                throw new ProductException("Invalid Category id");
            }
            return productRepository.save(existingProduct);
        }else{
            throw new ProductException("Invalid Product id");
        }
    }
    //get product by product id
    public Product getProductByProductId(int productId)  {
        if(productRepository.existsById(productId)){
            return productRepository.findById(productId).get();
        }else{
            throw new ProductException("Invalid Product Id");
        }
    }
    //delete product by product id
    public void deleteProductById(int productId) {
        if(productRepository.existsById(productId)){
             productRepository.deleteById(productId);
        }else{
            throw new ProductException("Invalid Product Id");
        }
    }
    //get all products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
