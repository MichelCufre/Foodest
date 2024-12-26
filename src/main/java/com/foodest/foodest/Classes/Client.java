package com.foodest.foodest.Classes;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Client extends User{
    private Cart cart;

    public Client(Cart cart) {
        this.cart = cart;
    }

    public Client() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
