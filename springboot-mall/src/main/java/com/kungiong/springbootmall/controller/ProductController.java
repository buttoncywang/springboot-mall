package com.kungiong.springbootmall.controller;

import com.kungiong.springbootmall.constant.ProductCategory;
import com.kungiong.springbootmall.dao.ProductQueryParams;
import com.kungiong.springbootmall.dto.ProductRequest;
import com.kungiong.springbootmall.model.Product;
import com.kungiong.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            //查詢條件 Filtering
           @RequestParam(required = false) ProductCategory category,
           @RequestParam(required = false) String search,
           //排序 Sorting
           @RequestParam(required = true,defaultValue = "created_date") String orderBy,
           @RequestParam(required = true,defaultValue = "desc") String sort,
            //分頁 Pagination
            @RequestParam(required = true,defaultValue ="5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(required = true,defaultValue ="0") @Min(0) Integer offset
    ){
        //將查詢參數提煉到ProductQueryParam中
        ProductQueryParams productQueryParams=new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSortBy(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        List<Product> productList=productService.getProducts(productQueryParams);
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product=productService.getProductById(productId);
        if(product!=null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
       Integer productId = productService.createProduct(productRequest);
       Product product=productService.getProductById(productId);
       return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){
        Product product=productService.getProductById(productId); //先查詢商品是否存在
        if(product!=null){//商品有存在，就去更新商品
            productService.updateProduct(productId,productRequest);
            Product updatedProduct=productService.getProductById(productId);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
