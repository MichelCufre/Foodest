package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Order;
import com.foodest.foodest.Repository.OrderRepository;
import com.foodest.foodest.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
}
