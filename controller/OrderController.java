package com.mftplus.spring02.controller;

import com.mftplus.spring02.model.entity.Order;
import com.mftplus.spring02.model.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @GetMapping("/{id}")
    public String getOrderById(Model model, @PathVariable Long id) {
        model.addAttribute("order", orderService.findById(id));
        return "editOrders"; //todo->edit order
    }

    @PostMapping
    public String addOrder(Order order) {
        orderService.save(order);
        log.info("Saved Orders {}", order);
        return "redirect:/orders";
    }

    @PutMapping
    public String updateOrder(Order order) {
        orderService.update(order);
        log.info("Updated Order {}", order);
        return "redirect:/orders";
    }

    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect: /orders";
    }
}
