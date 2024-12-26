package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Cart;
import com.foodest.foodest.Repository.CartRepository;
import com.foodest.foodest.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
}
