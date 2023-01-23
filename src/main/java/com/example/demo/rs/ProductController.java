package com.example.demo.rs;

import com.example.demo.dto.ProductTitleParam;
import com.example.demo.dto.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public interface ProductController {

    @GetMapping
    Response getProductTitle(ProductTitleParam productTitleParam);
}
