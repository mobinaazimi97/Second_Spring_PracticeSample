package com.mftplus.spring02.model.service.impl;

import com.mftplus.spring02.model.entity.OrderItem;
import com.mftplus.spring02.model.repository.OrderItemRepository;
import com.mftplus.spring02.model.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;

    }


    @Override
    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);

    }

    @Override
    public void update(OrderItem orderItem) {
        orderItemRepository.save(orderItem);

    }

    @Override
    public void delete(OrderItem orderItem) {
        orderItemRepository.delete(orderItem);

    }

    @Override
    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);

    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public OrderItem findByProductId(Long id) {
        return orderItemRepository.findByProductId(id);
    }

    @Override
    public OrderItem findByProductName(String name) {
        return orderItemRepository.findByProductName(name);
    }

    @Override
    public OrderItem findByOrderId(Long id) {
        return orderItemRepository.findByOrderId(id);
    }
}
