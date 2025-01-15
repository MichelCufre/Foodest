package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Order;
import com.foodest.foodest.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

//    @PostMapping("/register")
//    public ResponseEntity<Order> createRestaurantResponse(@RequestBody Order order) {
//        Order newOrder = orderService.createOrder(order.getUser(), order.getDesc(), order.getTotalPrice(), order.getProductList(),order.getStatus());
//        return ResponseEntity.ok(newOrder);
//    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
