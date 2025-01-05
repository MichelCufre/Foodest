package com.foodest.foodest.Classes;

import jakarta.persistence.*;
import lombok.Data;


@Entity
public class Client extends User{

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id", referencedColumnName = "userEmail")

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
