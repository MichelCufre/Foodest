package com.foodest.foodest.Classes;

import jakarta.persistence.*;
import lombok.Data;


@Entity
public class Client extends User{

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id", referencedColumnName = "userEmail")
    private Cart cart;

    public Client() {
    }

    public Client(String email, String name, String password, String imgUrl) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.imgUrl = imgUrl;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
