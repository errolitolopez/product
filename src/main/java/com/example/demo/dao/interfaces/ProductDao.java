package com.example.demo.dao.interfaces;

import com.example.demo.dao.entities.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getProducts();

    ProductEntity getProductById(ProductEntity param);
}