package com.example.demo.dao.impl;

import com.example.demo.dao.entities.ProductEntity;
import com.example.demo.dao.exception.ProductNotFoundException;
import com.example.demo.dao.interfaces.ProductDao;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl implements ProductDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Resource
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getProducts() {
        return productRepository.findAll(); // SELECT * FROM TBL_PRODUCT;
    }

    @Override
    public ProductEntity getProductById(ProductEntity param) {
        Optional<ProductEntity> product = productRepository.findById(param.getId()); // SELECT * FROM TBL_PRODUCT WHERE ID = params.id;

        if (!product.isPresent()) {
            throw new ProductNotFoundException();
        }

        return product.get();
    }
}
