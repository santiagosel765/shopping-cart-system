package com.shopping.product.service;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Map<String, Object>> getAllProducts();
    Map<String, Object> getProductById(Long id);
    List<Map<String, Object>> getProductsByCategory(String category);
    Map<String, Object> createProduct(Map<String, Object> product);
    Map<String, Object> updateProduct(Long id, Map<String, Object> product);
    Map<String, Object> deleteProduct(Long id);
}
