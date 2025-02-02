package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.*;
import com.foodest.foodest.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return order;
    }

//    public Order createOrder(User user, String description, Double totalPrice, List<Product> products, Boolean status) {}
//
//    public Order updateOrder(Long id, List<Product> products, Double totalPrice) {}

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
