package com.kungiong.springbootmall.dao;

import com.kungiong.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
