package com.mftplus.spring02.model.service;

import com.mftplus.spring02.model.entity.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);
    void update(Order order);
    void delete(Order order);
    void deleteById(Long id);
    List<Order> findAll();
    Order findById(Long id);
}
