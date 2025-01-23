package com.mftplus.spring02.model.entity;

import jakarta.persistence.*;

@Entity(name = "orderItemEntity")
@Table(name = "orderItem_tbl")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

                    //for test in ide :
//   @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.PERSIST},fetch = FetchType.EAGER)

                    //for test in Ui :
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Product product;
//@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
private Order order;
    private int quantity;

    public OrderItem(Product product, Order order, int quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }
    public OrderItem() {}

    public Long getId() {
        return id;
    }

    public OrderItem setId(Long id) {
        this.id = id;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public OrderItem setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderItem setOrder(Order order) {
        this.order = order;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
