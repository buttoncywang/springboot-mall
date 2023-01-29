package com.kungiong.springbootmall.dao;

import com.kungiong.springbootmall.constant.ProductCategory;

public class ProductQueryParams {
    private ProductCategory category;
    private String search;

    private String sortBy;
    private String orderBy;

    public java.lang.String getSortBy() {
        return sortBy;
    }

    public void setSortBy(java.lang.String sortBy) {
        this.sortBy = sortBy;
    }

    public java.lang.String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(java.lang.String orderBy) {
        this.orderBy = orderBy;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
