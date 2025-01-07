package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.Client;
import com.foodest.foodest.Classes.Order;
import com.foodest.foodest.Classes.Product;
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

    public List<Order> getAllOrders() {}

    public Order getOrderById(Long id) {}

    public Order createOrder(Client client, List<Product> products, Double totalPrice) {}

    public Order updateOrder(Long id, List<Product> products, Double totalPrice) {}

    public void deleteOrder(Long id) {}
}
