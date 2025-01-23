package com.mftplus.spring02.model.entity;

import jakarta.persistence.*;


@Entity(name = "productEntity")
@Table(name = "product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String serialNumber;
    private Long price;

//    public Product(Long id,String name, String brand,String serialNumber,Long price) {
//        this.id = id;
//        this.name = name;
//        this.brand = brand;
//        this.serialNumber = serialNumber;
//        this.price = price;
//    }
    public Product() {}
//
    public Product(String name, String brand, String serialNumber, Long price) {
        this.name = name;
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Product setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Product setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public Product setPrice(Long price) {
        this.price = price;
        return this;
    }
}
