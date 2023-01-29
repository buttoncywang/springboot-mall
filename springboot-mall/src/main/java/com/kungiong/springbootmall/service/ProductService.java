package com.kungiong.springbootmall.service;

import com.kungiong.springbootmall.dao.ProductQueryParams;
import com.kungiong.springbootmall.dto.ProductRequest;
import com.kungiong.springbootmall.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId,ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
