package com.mftplus.spring02.model.service;

import com.mftplus.spring02.model.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    void save(OrderItem orderItem);

    void update(OrderItem orderItem);

    void delete(OrderItem orderItem);

    void deleteById(Long id);

    List<OrderItem> findAll();

    OrderItem findById(Long id);

    OrderItem findByProductId(Long id);

    OrderItem findByProductName(String name);

    OrderItem findByOrderId(Long id);

}
