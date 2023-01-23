package com.example.demo.service.interfaces;

import com.example.demo.dao.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll();

    String getProductTitleById(Long id);
}
