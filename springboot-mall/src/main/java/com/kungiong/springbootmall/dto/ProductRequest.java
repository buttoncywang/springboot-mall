package com.kungiong.springbootmall.dto;

import com.kungiong.springbootmall.constant.ProductCategory;
import javax.validation.constraints.NotNull;

public class ProductRequest {
    @NotNull
    private String productName;
    @NotNull
    private ProductCategory category;
    @NotNull
    private String imageUrl;
    @NotNull
    private Integer price;
    @NotNull
    private Integer stock;
    private String description;

    public java.lang.String getProductName() {
        return productName;
    }

    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public java.lang.String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(java.lang.String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public java.lang.Integer getPrice() {
        return price;
    }

    public void setPrice(java.lang.Integer price) {
        this.price = price;
    }

    public java.lang.Integer getStock() {
        return stock;
    }

    public void setStock(java.lang.Integer stock) {
        this.stock = stock;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }
}
