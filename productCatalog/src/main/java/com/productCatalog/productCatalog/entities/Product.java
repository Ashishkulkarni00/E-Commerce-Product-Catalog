package com.productCatalog.productCatalog.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;

    private String product_name;
    private double product_price;
    private String product_description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(int product_id, String product_name, double product_price, String product_description, Category category) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.category = category;
    }

    public Product() {
    }
}
