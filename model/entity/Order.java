package com.mftplus.spring02.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "orderEntity")
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String customerName;    //todo:create user class
    private LocalDate orderDate;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList;

    public Order(Double price, String customerName, LocalDate orderDate, List<OrderItem> orderItemList) {
        this.price = price;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.orderItemList = orderItemList;
    }
    public Order(Double price, String customerName, LocalDate orderDate) {
        this.price = price;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public Order() {}

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Order setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Order setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public Order setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
        return this;
    }
}
