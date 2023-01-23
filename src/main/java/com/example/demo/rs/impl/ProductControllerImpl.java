package com.example.demo.rs.impl;

import com.example.demo.dao.exception.ProductNotFoundException;
import com.example.demo.dto.ProductTitleParam;
import com.example.demo.dto.ProductTitleResponse;
import com.example.demo.dto.Response;
import com.example.demo.rs.interfaces.ProductController;
import com.example.demo.service.exception.InvalidParamsException;
import com.example.demo.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductControllerImpl implements ProductController {

    @Resource
    private ProductService productService;

    @Override
    public Response getProductTitle(ProductTitleParam productTitleParam) {
        Response<ProductTitleResponse> response = new Response<>();
        ProductTitleResponse productTitleResponse = new ProductTitleResponse();
        String productTitle = null;
        try {
            productTitle = productService.getProductTitleById(productTitleParam.getId());
        } catch (InvalidParamsException e) {
            response.setMessage("Invalid parameter id.");
            response.setCode(-1);
            return response;
        } catch (ProductNotFoundException e) {
            response.setMessage("Product with id=" + productTitleParam.getId() + " is not found.");
            response.setCode(-1);
            return response;
        }
        productTitleResponse.setTitle(productTitle);
        response.setCode(1);
        response.setMessage("Success");
        response.setData(productTitleResponse);
        return response;
    }
}
