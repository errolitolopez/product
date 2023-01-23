package com.example.demo;

import com.example.demo.dao.entities.ProductEntity;
import com.example.demo.dao.interfaces.ProductDao;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static RestTemplate restTemplate = new RestTemplate();

    @Resource
    private ProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        String forObject = restTemplate.getForObject("https://dummyjson.com/products/1", String.class);
//        System.out.println(forObject);
//
//        List<ProductEntity> products = productDao.getProducts();
//
//        for (ProductEntity product : products) {
//            if (product != null) {
//                System.out.println("product=" + ToStringBuilder.reflectionToString(product));
//            }
//        }
    }
}
