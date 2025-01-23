package com.mftplus.spring02.controller;

import com.mftplus.spring02.model.entity.Product;
import com.mftplus.spring02.model.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findById(id));
        return "editProducts";
    }

    @GetMapping("/name/{name}")
    public String getProductByName(Model model, @PathVariable String name) {
        if (productService.findByName(name) != null) {
            log.info("product found by name {}", productService.findByName(name).get(0));
            model.addAttribute("product", productService.findByName(name).get(0));
            return "redirect:/products";
        } else {
            log.error("Name NotFoundException");
            return null;
        }
    }

    @GetMapping("/brand/{brand}")
    public String getProductByBrand(Model model, @PathVariable String brand) {
        if (productService.findByBrand(brand) != null) {
            log.info("product found by brand {}", productService.findByBrand(brand).get(0));
            model.addAttribute("product", productService.findByBrand(brand).get(0));
            return "redirect:/products";
        } else {
            log.error("Brand NotFoundException");
            return null;
        }
    }

    @PostMapping
    public String addProduct(Product product) {
        productService.save(product);
        log.info("Saved Products {}", product);
        return "redirect:/products";
    }

    @PutMapping()
    public String updateProduct(Product product) {
        productService.update(product);
        log.info("Updated Product {}", product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}

