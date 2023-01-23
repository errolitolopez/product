package com.example.demo.service.impl;

import com.example.demo.dao.entities.ProductEntity;
import com.example.demo.dao.exception.ProductNotFoundException;
import com.example.demo.dao.interfaces.ProductDao;
import com.example.demo.remote.interfaces.DummyJsonRemote;
import com.example.demo.remote.model.DummyJsonProduct;
import com.example.demo.service.exception.InvalidParamsException;
import com.example.demo.service.interfaces.ProductService;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private ProductDao productDao;

    @Resource
    private DummyJsonRemote dummyJsonRemote;

    @Override
    public List<ProductEntity> getAll() {
        return productDao.getProducts();
    }

    @Override
    public String getProductTitleById(Long id) {
        return getProductEntity(id).getTitle();
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return getProductEntity(id);
    }

    private ProductEntity getProductEntity(Long id) {
        if (ObjectUtils.isEmpty(id)) {
            logger.error("Invalid parameter id with value={}", id);
            throw new InvalidParamsException("Invalid parameter id");
        }

        DummyJsonProduct dummyJsonProduct = dummyJsonRemote.products(id);

        if (ObjectUtils.isEmpty(dummyJsonProduct)) {
            logger.error("Product not found in dummy json api with id={}", id);
            throw new ProductNotFoundException("Product not found in dummy json api with id=" + id);
        }

        try {
            ProductEntity param = new ProductEntity();
            param.setTitle(dummyJsonProduct.getTitle());
            return productDao.getProductByTitle(param);
        } catch (ProductNotFoundException e) {
            logger.error("Product with id={} not found", id, e);
            throw e;
        }
    }
}
