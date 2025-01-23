package com.mftplus.spring02.controller;

import com.mftplus.spring02.model.entity.OrderItem;
import com.mftplus.spring02.model.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orderItems")
@Slf4j
public class OrderItemController {
    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public String getOrderItems(Model model) {
        model.addAttribute("orderItem", new OrderItem());
        model.addAttribute("orderItems", orderItemService.findAll());
        return "orderItems";
    }

    @GetMapping("/{id}")
    public String getItemsById(Model model, @PathVariable Long id) {
        model.addAttribute("orderItem", orderItemService.findById(id));
        return "editOrderItems";
    }

    @GetMapping("/productId/{productId}")
    public String getItemsByProductId(Model model, @PathVariable Long productId) {
        if (orderItemService.findByProductId(productId) != null) {
            log.info("product found by id {}", orderItemService.findByProductId(productId));
            model.addAttribute("product", orderItemService.findByProductId(productId));
            return "redirect:/orderItems";
        } else {
            log.error("Product Id NotFoundException");
            return null;
        }
    }

    @GetMapping("/name/{name}")
    public String getItemsByProductName(Model model, @PathVariable String name) {
        if (orderItemService.findByProductName(name) != null) {
            log.info("product found by name {}", orderItemService.findByProductName(name));
            model.addAttribute("product", orderItemService.findByProductName(name));
            return "redirect:/orderItems";
        } else {
            log.error("Product Name NotFoundException");
            return null;
        }
    }

    @GetMapping("/orderId/{orderId}")
    public String getItemsByOrderId(Model model, @PathVariable Long orderId) {
        if (orderItemService.findByOrderId(orderId) != null) {
            log.info("order found by id {}", orderItemService.findByOrderId(orderId));
            model.addAttribute("order", orderItemService.findByOrderId(orderId));
            return "redirect:/orderItems";
        } else {
            log.error("OrderIdNotFoundException");
            return null;
        }
    }

    @PostMapping
    public String addItem(OrderItem orderItem) {
        orderItemService.save(orderItem);
        log.info("Saved Order Item {}", orderItem);
        return "redirect:/orderItems";
    }

    @PutMapping
    public String updateItem(OrderItem orderItem) {
        orderItemService.update(orderItem);
        log.info("Updated Order Item {}", orderItem);
        return "redirect:/orderItems";
    }

    @DeleteMapping("/{id}")
    public String deleteOrderItemById(@PathVariable Long id) {
        orderItemService.deleteById(id);
        return "redirect:/orderItems";
    }

}
