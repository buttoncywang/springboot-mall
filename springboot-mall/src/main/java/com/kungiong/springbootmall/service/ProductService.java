package com.kungiong.springbootmall.service;

import com.kungiong.springbootmall.dto.ProductRequest;
import com.kungiong.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);
}
