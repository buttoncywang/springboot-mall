package com.kungiong.springbootmall.rowmapper;

import com.kungiong.springbootmall.constant.ProductCategory;
import com.kungiong.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product=new Product();
        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));
        //從資料庫取出的字串，在Enum中找尋對應的值
        String categoryString=resultSet.getString("category");
        ProductCategory category=ProductCategory.valueOf(categoryString);
        product.setCategory(category);
        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreateDate(resultSet.getDate("created_date"));
        product.setLastModifiedDate(resultSet.getDate("last_modified_date"));
        return product;
    }
}
