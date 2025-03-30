package com.shopping.product.service.impl;

import com.shopping.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final String BASE_URL = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate;

    @Override
    public List<Map<String, Object>> getAllProducts() {
        return Arrays.asList(restTemplate.getForObject(BASE_URL, Map[].class));
    }

    @Override
    public Map<String, Object> getProductById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Map.class);
    }

    @Override
    public List<Map<String, Object>> getProductsByCategory(String category) {
        return Arrays.asList(restTemplate.getForObject(BASE_URL + "/category/" + category, Map[].class));
    }

    @Override
    public Map<String, Object> createProduct(Map<String, Object> product) {
        return restTemplate.postForObject(BASE_URL, product, Map.class);
    }

    @Override
    public Map<String, Object> updateProduct(Long id, Map<String, Object> product) {
        restTemplate.put(BASE_URL + "/" + id, product);
        return product;
    }

    @Override
    public Map<String, Object> deleteProduct(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
        return Map.of("message", "Product deleted successfully (fake)");
    }
}
