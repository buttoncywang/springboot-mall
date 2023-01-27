package com.kungiong.springbootmall.dao;

import com.kungiong.springbootmall.dto.ProductRequest;
import com.kungiong.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
