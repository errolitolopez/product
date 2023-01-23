package com.example.demo.remote.impl;

import com.example.demo.remote.interfaces.DummyJsonRemote;
import com.example.demo.remote.model.DummyJsonProduct;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class DummyJsonRemoteImpl implements DummyJsonRemote {

    private static final Logger logger = LoggerFactory.getLogger(DummyJsonRemoteImpl.class);

    private static RestTemplate restTemplate = new RestTemplate();

    @Override
    public DummyJsonProduct products(Long id) {
        String url = "https://dummyjson.com/products/" + id;
        DummyJsonProduct forObject = null;
        try {
            forObject = restTemplate.getForObject(url, DummyJsonProduct.class);
            logger.info("Url: {}, Dummy json api product response: {}", url, ToStringBuilder.reflectionToString(forObject));
        } catch (RestClientException e) {
            logger.error("Api error: ", e);
        }
        return forObject;
    }
}
