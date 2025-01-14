package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.Cart;
import com.foodest.foodest.Classes.Product;
import com.foodest.foodest.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartByEmail(String userEmail) {
        return cartRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Cart not found with email: " + userEmail));
    }

    public void updateCart(String userEmail, List<Product> products) {
        Cart cart = cartRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Cart not found with email: " + userEmail));
        cart.setProductList(products);
    }

    public void emptyCart(String userEmail) {
        Cart cart = cartRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Cart not found with email: " + userEmail));
        List<Product> productList = new ArrayList<>();
        cart.setProductList(productList);
    }
}
