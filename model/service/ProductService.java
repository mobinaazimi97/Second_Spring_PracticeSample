package com.mftplus.spring02.model.service;

import com.mftplus.spring02.model.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    void delete(Product product);

    void deleteById(Long id);

    void update(Product product);

    List<Product> findAll();

    Product findById(Long id);

    List<Product> findByName(String name);

    List<Product> findByBrand(String brand);
}
