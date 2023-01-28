package com.kungiong.springbootmall.dao;

import com.kungiong.springbootmall.constant.ProductCategory;
import com.kungiong.springbootmall.dto.ProductRequest;
import com.kungiong.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductCategory category,String search);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
