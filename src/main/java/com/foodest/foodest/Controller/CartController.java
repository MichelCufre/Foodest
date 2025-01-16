package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Cart;
import com.foodest.foodest.Classes.Client;
import com.foodest.foodest.Classes.Product;
import com.foodest.foodest.Repository.CartRepository;
import com.foodest.foodest.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{email}")
    public ResponseEntity<Cart> getCartByEmail(@PathVariable String email) {
        return ResponseEntity.ok(cartService.getCartByEmail(email));
    }

    @PostMapping("/{email}/update")
    public ResponseEntity<String> updateCart(
            @PathVariable String email,
            @RequestBody List<Product> products) {
        cartService.updateCart(email, products);
        return ResponseEntity.ok("Cart updated successfully!");
    }

    @GetMapping("/{email}/empty")
    public ResponseEntity<String> emptyCart(@PathVariable String email) {
        cartService.emptyCart(email);
        return ResponseEntity.ok("Client deleted successfully!");
    }
}
