package com.mftplus.spring02.model.repository;

import com.mftplus.spring02.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    OrderItem findByOrderId(Long id);

    OrderItem findByProductId(Long id);

    OrderItem findByProductName(String name);

}
