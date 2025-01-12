package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.Cart;
import com.foodest.foodest.Classes.Client;
import com.foodest.foodest.Classes.Product;
import com.foodest.foodest.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(Long id) {}

    public Cart createCart(Client client) {}

    public Cart updateCart(Long id, List<Product> products) {}

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
